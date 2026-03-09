plugins {
    kotlin("jvm") version "2.3.0"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.19"
}

group = "io.github.takenoko4096"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://libraries.minecraft.net")
}

dependencies {
    implementation("com.mojang:brigadier:1.0.18")
    paperweight.paperDevBundle("1.21.11-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(21)
}
