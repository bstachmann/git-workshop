plugins {
    kotlin("jvm") version "1.9.10"
    id("application")
}



apply(plugin = "application")

val ktorVersion: String by extra { "1.6.8" }
// val ktorVersion: String by extra { "2.3.4" }

allprojects {

    repositories {
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
        maven("https://dl.bintray.com/jetbrains/markdown")
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    dependencies {

        implementation(kotlin("script-runtime"))
        implementation(kotlin("stdlib"))
    }

}

dependencies {
    implementation(project(":generator"))
}


application {
    mainClass.set("de.kapitel26.gitsamplebuilder.gitworkshop.GitworkshopsamplesKt")
}


tasks.assembleDist {
    dependsOn(tasks.named<JavaExec>("distUebungenZip")) 
}

task("distUebungenMarkdown", JavaExec::class) {
    group = "Distribution"
    description = "Deploy markdown files for exercises, to website dir."
    dependsOn("run")

    mainClass.set("de.kapitel26.gitsamplebuilder.BuildAndDeployUebungenToWebsiteKt")
    classpath = sourceSets["main"].runtimeClasspath
}

task("distUebungenZip", JavaExec::class) {
    group = "Distribution"/* \ */
    description = "Create a new zip file."
    dependsOn("run")

    mainClass.set("de.kapitel26.gitsamplebuilder.BuildAndDeployUebungenToZipKt")
    classpath = sourceSets["main"].runtimeClasspath
}

task("sandbox", JavaExec::class) {
    group = "Application"
    description = "Run sandbox samples from gitworkshopsandbox.kt."
    mainClass.set("de.kapitel26.gitsamplebuilder.gitworkshop.GitworkshopsandboxKt")
    classpath = sourceSets["main"].runtimeClasspath
}

task("progress", JavaExec::class) {
    group = "Application"
    description = "Run sandbox samples from gitworkshopsandbox.kt."
    mainClass.set("de.kapitel26.gitsamplebuilder.UebungenProgressServerKt")
    classpath = sourceSets["main"].runtimeClasspath
}

