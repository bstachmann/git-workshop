package de.kapitel26.gitsamplebuilder

import com.fasterxml.jackson.module.kotlin.*
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.request
import io.ktor.application.install
import io.ktor.html.respondHtml
import io.ktor.http.*
import io.ktor.util.pipeline.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.sessions.*
import io.ktor.response.respondRedirect
import java.io.File
import java.net.URL
import kotlin.math.abs
import kotlinx.html.*
import kotlin.coroutines.*

fun main() {
    val adminServer = embeddedServer(Netty, port = 8040) { adminModule() }
    adminServer.start(wait = false)
    val participantsServer = embeddedServer(Netty, port = 8080) { participantsModule() }
    participantsServer.start(wait = true)
}

data class Progress(
        val aufgaben: List<Pair<String, List<String>>>,
        val aktuelleAufgabe: Pair<String, List<String>>,
        val participants: Map<String, String>,
        val achievements: Map<String, Set<String>>
)

data class UserSession(val userId: String)

val progressFile = File("build/git-uebungen/progress.json")

val mapper = jacksonObjectMapper()

var state: Progress =
        if (progressFile.exists()) {
            println("Restoring state from file")
            mapper.readValue(progressFile)
        } else {
            println("Fresh startup")
            readAufgaben().let { aufgaben ->
                Progress(aufgaben, aufgaben.first(), emptyMap(), emptyMap())
            }
        }

fun update(newState: Progress) {
    state = newState
    mapper.writerWithDefaultPrettyPrinter().writeValue(progressFile, newState)
}

fun readAufgaben(): List<Pair<String, List<String>>> {
    val s: String = File("build/git-uebungen/aufgaben.json").readText()
    return mapper.readValue(s)
}

fun Application.participantsModule() {
    install(Sessions) {
        cookie<UserSession>("user_session")
    }

    routing {
        aufgabenFilesLocalJekyll()
        workshopSiteFromLocalJekyll()
        participantsPage()
        registerPage()
        get("/") { call.respondRedirect("/git-workshop") }
        get("*") { call.respondHtml { body { p { +"Fallback" } } } }
    }
}

fun Application.adminModule() {
    routing {
        adminDashboad()
    }
}

fun Route.aufgabenFilesLocalJekyll() {
    get("/git-workshop/git-uebungen/{path...}") { 
        val userId = call.sessions.get<UserSession>()?.userId
        val sidParam = call.parameters["sid"]
        println("userId=$userId, sid=$sidParam")
        if (sidParam != null && userId != null) {
            val completed = call.parameters["completed"].toBoolean()
            val olda: Set<String> = state.achievements[sidParam] ?: emptySet()
            val newa = if(completed) olda + userId else olda -userId
            update(state.copy(achievements = state.achievements + (sidParam to newa)))
        }

        val response = this.getStaticContent("git-uebungen/" + (call.parameters.getAll("path")?.joinToString("/") ?: ""))
        val processedContent = response.readText().replace(
            """\<\!\-\-UEB\-(.+?)\-\-\> \<h2\> (.+?)\ <\/h2\>""".toRegex(), 
            { step -> 
                val aufgabname = step.groups[1]?.value
                val schrittname = step.groups[2]?.value
                val schrittSid = abs((aufgabname to schrittname).hashCode()).toString()    
                val isCompleted = state.achievements[schrittSid]?.contains(call.sessions.get<UserSession>()?.userId) ?: false
                
                """<h2>$schrittname <a href="?sid=$schrittSid&completed=${!isCompleted}">${ if(isCompleted) "erledigt" else "offen"} </a></h2>"""
            }
        )
        call.respondText(processedContent, status = response.status, contentType = response.contentType())
    }
}

fun Route.workshopSiteFromLocalJekyll() {
    get("/git-workshop/{path...}") { 
        
        val response = this.getStaticContent(call.parameters.getAll("path")?.joinToString("/") ?: "")
        call.respondBytes(response.readBytes(), status = response.status, contentType = response.contentType())
    }
}


suspend fun PipelineContext<Unit, ApplicationCall>.getStaticContent(path: String) : HttpResponse =
    "http://localhost:4000/git-workshop/${path}"
        .also { println("Requesting: $it") } 
        .let { url ->   HttpClient().use {  c -> c.request(url) {} } }



fun Route.participantsPage() {
    get("/me") {
        call.respondHtml {
            val sessions: UserSession? = call.sessions.get()
            val userId = call.parameters["id"] ?: sessions?.userId
            val sid = call.parameters["sid"]
            val completed = call.parameters["completed"].toBoolean()
            if (sid != null && userId != null) {
                val olda: Set<String> = state.achievements[sid] ?: emptySet()
                val newa = if(completed) olda + userId else olda -userId
                update(state.copy(achievements = state.achievements + (sid to newa)))
            }

            head { 
                // meta() { 
                //     httpEquiv="refresh"
                //     content="20" 
                // }
            }

            body {
                h1 { text("Git Workshop - Progress Monitor") }
                if (userId == null) {
                    form(action = "/register", method = FormMethod.get) {
                        label { text("Dein Name/Alias:") }
                        input(name = "newAlias") { value = "torfnase" }
                    }
                } else {
                    h2 { text("Hallo ${state.participants[userId]}!") }
                    h2 { text("Aufgabe ${state.aktuelleAufgabe.first}") }
                    state.aktuelleAufgabe.second.forEach { schritt ->
                        p {
                            val schrittSid = abs((state.aktuelleAufgabe.first to schritt).hashCode())
                                            .toString()
                            text(schritt)
                            val isCompleted = state.achievements[schrittSid]?.contains(userId) ?: false
                            a(href = "/?id=$userId&sid=$schrittSid&completed=${!isCompleted}") { +(if(isCompleted) " erledigt" else " offen"  ) }
                        }
                    }
                }
            }
        }
    }
}

fun Route.registerPage() {
    get("/register") {
        val newAlias = call.parameters["newAlias"] ?: throw Exception("Missing parameter newAlias")
        val newUserId = abs("participant/$newAlias".hashCode()).toString()
        if (state.participants[newUserId] == null) {
            update(state.copy(participants = state.participants + (newUserId to newAlias)))
            call.sessions.set(UserSession(newUserId))
            call.respondRedirect("/")
        } else {
            call.respondHtml {
                body { p { +"Alias $newAlias ist bereits vergeben." } }
            }
        }
    }
}

fun Route.adminDashboad() {
    get("/") {
        val selected = call.parameters["select"] ?: "?"
        update(
                state.copy(
                        aktuelleAufgabe = state.aufgaben.find { it.first == selected }
                                        ?: state.aufgaben.first()
                )
        )
        call.respondHtml {
            head { 
                // meta() { 
                //     httpEquiv="refresh"
                //     content="2 0" 
                // }
            }

            body {
                h1 { text("Git Workshop - Progress Monitor") }
                h2 { text("Aktuelle Aufgabe") }
                val totalNum = state.participants.size
                state.aktuelleAufgabe.also { (aufgabe, schritte) ->
                    schritte.forEach { schritt ->
                        val sid =
                                abs((state.aktuelleAufgabe.first to schritt).hashCode())
                                        .toString()
                        p { +"[$sid] $aufgabe/$schritt ${state.achievements[sid]?.size}/$totalNum ${state.achievements[sid]?.map { state.participants[it] }}" }
                    }
                }
                h2 { text("Aufgaben") }
                form(action = "/", method = FormMethod.get) {
                    state.aufgaben.map { it.first }.forEach {
                        input(name = "select") {
                            value = it
                            type = InputType.radio
                            checked = it == state.aktuelleAufgabe.first
                            onChange = "this.form.submit()"
                            text(it)
                        }
                        br {}
                    }
                }
                h2 { text("Teilnehmer") }
                p {
                    state.participants.forEach { (userId, alias) ->
                        a(href="/?id=$userId") { +"$alias $userId" }
                        br {}
                    }
                }
            }
        }
    }    
}

