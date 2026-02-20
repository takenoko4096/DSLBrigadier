plugins {
    kotlin("jvm") version "2.3.0"
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "io.github.takenoko4096"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://libraries.minecraft.net")
}

dependencies {
    implementation("com.mojang:brigadier:1.0.18")
}

kotlin {
    jvmToolchain(21)
}

java {
    withSourcesJar()
    withJavadocJar()
}
/*
publishing {
    publications {
        register<MavenPublication>("maven") {
            pom {
                name.set(project.name)
                description.set("atode kaku yoon") // TODO
                url.set("https://github.com/takenoko4096/DSLBrigadier")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/takenoko4096/DSLBrigadier/blob/master/LICENSE")
                        distribution.set("repo")
                    }
                }

                developers {
                    developer {
                        id.set("takenoko4096")
                        name.set("TakenokoII")
                        email.set("subnokoii78@gmail.com")
                    }
                }

                scm {
                    url.set("https://github.com/takenoko4096/DSLBrigadier")
                }
            }
        }
    }
}

tasks {
    named<SonatypeCentralUploadTask>("sonatypeCentralUpload") {
        dependsOn("jar", "sourcesJar", "javadocJar", "generatePomFileForMavenPublication")

        username = System.getenv("SONATYPE_CENTRAL_USERNAME")
        password = System.getenv("SONATYPE_CENTRAL_PASSWORD")

        archives = files(
            tasks.named("jar"),
            tasks.named("sourcesJar"),
            tasks.named("javadocJar")
        )

        pom = file(
            tasks.named("generatePomFileForMavenPublication").get().outputs.single()
        )

        signingKey = System.getenv("SIGNING_KEY")
        signingKeyPassphrase = System.getenv("SIGNING_PASSWORD")
    }
}
*/
