import org.jetbrains.changelog.closure

plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.7.2"
    id("org.jetbrains.changelog") version "1.1.2"
}

group = "pl.lksztmczk"
version = "2.0.0"

var platformVersion = "2020.1"
var pluginSinceBuild = "201"
var pluginVerifierIdeVersions = "2020.1.4, 2020.2.4, 2020.3.3, 2021.1"

repositories {
    mavenCentral()
}

intellij {
    pluginName = "Open in terminal"
    version = platformVersion
    updateSinceUntilBuild = true
}

changelog {
    version = project.version.toString()
    unreleasedTerm = "Unreleased"
    groups = emptyList()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    patchPluginXml {
        version(version)
        sinceBuild(pluginSinceBuild)
        changeNotes(
                closure {
                    changelog.getAll().values.joinToString("\n") {
                        it.withHeader(true).toHTML()
                    }
                }
        )
    }

    runPluginVerifier {
        ideVersions(pluginVerifierIdeVersions)
    }
}
