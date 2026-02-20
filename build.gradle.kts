plugins {
    kotlin("jvm") version "2.3.0"
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
