package de.kapitel26.gitsamplebuilder

import com.fasterxml.jackson.module.kotlin.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.request
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtml
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.coroutines.*
import kotlin.math.*
import kotlin.random.*
import kotlinx.html.*
import util.openFileInLocalVscode

fun main() {
    val server =
            embeddedServer(Netty, port = 8000) {
                localVscodeModule()
                participantsModule()
            }
    server.start(wait = true)
}

data class Progress(
        val aufgaben: List<Pair<String, List<String>>>,
        val aktuelleAufgabe: Pair<String, List<String>>,
        val participants: Map<String, String>, // id to alias
        val achievements: Map<String, Set<String>>,
        val adminId: String? = null
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
    install(Sessions) { cookie<UserSession>("user_session") }

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondHtml(HttpStatusCode.InternalServerError) {
                body {
                    h1 { +"Dumm gelaufen: $cause.message" }
                    pre { +cause.stackTraceToString() }
                }
            }
        }
    }

    routing {
        aufgabenFilesLocalJekyll()
        workshopSiteFromLocalJekyll()
        progressDashboad()
        get("/") { call.respondRedirect("/git-workshop") }
    }
}

val ApplicationCall.userId: String
    get() =
            sessions.get<UserSession>()?.userId
                    ?: java.util.Random().nextInt().toString().also {
                        sessions.set(UserSession(it))
                    }

fun Route.aufgabenFilesLocalJekyll() {
    get("/git-workshop/markdown-git-uebungen{language_suffix}/{path...}") {
        // println("Aufgabe request ${call.parameters.getAll("path")}")
        val previous = call.sessions.get<UserSession>()
        val session =
                if (previous != null && state.participants.containsKey(previous.userId)) previous
                else
                        Random.Default.nextInt()
                                .let { "%08x".format(it) }
                                .let { UserSession(it) }
                                .also {
                                    call.sessions.set(it)
                                    // println("Starting new session with userId $it")
                                    update(
                                            state.copy(
                                                    participants =
                                                            state.participants +
                                                                    (it.userId to it.userId),
                                                    adminId = state.adminId ?: it.userId
                                            )
                                    )
                                }
        val userId = session.userId

        call.parameters["newAlias"]?.let {
            update(state.copy(participants = state.participants + (userId to it)))
        }

        if (call.parameters["signout"] != null) {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/git-workshop")
        } else if (state.participants[userId] == userId) {
            call.respondHtml() {
                body {
                    h2 { +"Git Workshop - Progress Monitor - Teilnehmer" }
                    p {
                        +"Gib einen Namen oder Alias an, damit Dir Dein Übungsfortschritt zugeordnet werden kann."
                    }
                    form(action = "#", method = FormMethod.get) {
                        label { text("Dein Name/Alias:") }
                        input(name = "newAlias") { value = "" }
                        submitInput()
                    }
                }
            }
        } else {
            val sidParam = call.parameters["sid"]
            // println("userId=$userId, sid='$sidParam'")
            if (sidParam != null) {
                val completed = call.parameters["completed"].toBoolean()
                val previousAchievements: Set<String> = state.achievements[sidParam] ?: emptySet()
                val updatedAchievements =
                        if (completed) previousAchievements + userId
                        else previousAchievements - userId
                update(
                        state.copy(
                                achievements =
                                        state.achievements + (sidParam to updatedAchievements)
                        )
                )
            }

            val response =
                    this.getStaticContent(
                            "markdown-git-uebungen${call.parameters["language_suffix"] ?: ""}/" +
                                    (call.parameters.getAll("path")?.joinToString("/") ?: "")
                    )
            // Schritt 1 - Navigation in Übungsverzeichnisse <!-- UEB/Das `git`-Kommando!/1 -->
            // </h2>
            val processedContent =
                    response.bodyAsText()
                            .replace(
                                    """\<\!\-\- UEB\/(.+?)\/(.+?) \-\-\>""".toRegex(),
                                    { step ->
                                        val aufgabname = step.groups[1]?.value ?: "unknown"
                                        val schrittnummer = step.groups[2]?.value ?: "missing"
                                        val sid = "${aufgabname}/${schrittnummer}"
                                        val isCompleted =
                                                state.achievements[sid]?.contains(
                                                        call.sessions.get<UserSession>()?.userId
                                                )
                                                        ?: false
                                        // println("INSERT '${aufgabname}' num='${schrittnummer}'
                                        // sid=${sid}")
                                        """<b><a href="?sid=${URLEncoder.encode(sid, StandardCharsets.UTF_8.toString())}&completed=${!isCompleted}">${ if(isCompleted) "☑" else "☐"} </a></b></h2>"""
                                    }
                            )
            call.respondText(
                    processedContent,
                    status = response.status,
                    contentType = response.contentType()
            )
        }
    }
}

fun Route.workshopSiteFromLocalJekyll() {
    get("/git-workshop/{path...}") {
        val response =
                this.getStaticContent(call.parameters.getAll("path")?.joinToString("/") ?: "")
        call.respondBytes(
                response.readBytes(),
                status = response.status,
                contentType = response.contentType()
        )
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.getStaticContent(path: String): HttpResponse =
        "http://localhost:4000/git-workshop/${path}"
        // .also { println("Requesting: $it") }
        .let { url -> HttpClient().use { c -> c.request(url) {} } }

fun Route.progressDashboad() {
    get("/progress") {
        if (call.sessions.get<UserSession>()?.userId ?: -1 == state.adminId)
                call.progressDashboardResponse()
        else call.progressDashboardForbiddenResponse()
    }
}

suspend fun ApplicationCall.progressDashboardForbiddenResponse() {
    respond(HttpStatusCode.Forbidden, "Forbidden for user: ${sessions.get<UserSession>()}")
}

suspend fun ApplicationCall.progressDashboardResponse() {
    val selected = parameters["select"] ?: "?"
    update(
            state.copy(
                    aktuelleAufgabe = state.aufgaben.find { it.first == selected }
                                    ?: state.aufgaben.first()
            )
    )
    respondHtml {
        body {
            h1 { text("Git Workshop - Progress Monitor") }
            h2 { text("Aktuelle Aufgabe") }
            val totalNum = state.participants.size
            state.aktuelleAufgabe.also { (aufgabe, schritte) ->
                schritte.forEachIndexed { schrittnummer, schritt ->
                    val sid = "${state.aktuelleAufgabe.first}/${schrittnummer}"
                    //  println("REPORTING '${state.aktuelleAufgabe.first}' num='${schrittnummer}'
                    // sid=${sid}")
                    p {
                        +"$aufgabe/$schritt ${state.achievements[sid]?.size}/$totalNum ${state.achievements[sid]?.map { state.participants[it] }} sid=$sid"
                    }
                }
            }
            h2 { text("Aufgaben") }
            form(action = "/progress", method = FormMethod.get) {
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
                    a(href = "/?id=$userId") { +"$alias $userId" }
                    br {}
                }
            }
        }
    }
}

fun Application.localVscodeModule() {
    routing { localVscode() }
}

fun Route.localVscode() {
    get("/localvscode/{path...}") {
        if (call.sessions.get<UserSession>()?.userId ?: -1 == state.adminId)
                call.localVscodeResponse()
        else call.localVscodeForbidden()
    }
}

suspend fun ApplicationCall.localVscodeForbidden() {
    respond(HttpStatusCode.Forbidden, "Forbidden for user: ${sessions.get<UserSession>()}")
}

suspend fun ApplicationCall.localVscodeResponse() {
    val pathToOpen = parameters.getAll("path")?.joinToString("/") ?: ""
    try {
        openFileInLocalVscode(pathToOpen)
        respondRedirect(request.headers["Referer"] ?: "/")
    } catch (e: RuntimeException) {
        respondHtml {
            body {
                h1 { text("Couldn't open {$pathToOpen} in local VScode") }

                p {
                    text(
                            StringWriter().let {
                                e.printStackTrace(PrintWriter(it))
                                it.toString()
                            }
                    )
                }
            }
        }
    }
}
