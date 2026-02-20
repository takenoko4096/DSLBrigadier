plugins {
    kotlin("jvm") version "2.3.0"
    `maven-publish`
    id("cl.franciscosolis.sonatype-central-upload") version "1.0.2"
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

publishing {
    publications {
        register<MavenPublication>("maven") {
            pom {
                name.set(project.name)
                description.set("atode kaku yoon") // TODO
                url.set("https://github.com/takenoko4096/DSLBrigadier")

                licenses {
                    name.set("MIT License")
                    url.set("https://github.com/takenoko4096/DSLBrigadier/blob/master/LICENSE")
                }
            }
        }
    }
}