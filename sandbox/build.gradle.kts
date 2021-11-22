plugins {
  kotlin("jvm") version "1.5.30"
  application
}

repositories {
  mavenCentral()
  google()
  maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

description = "Local consumer sandbox"

application {
  mainClass.set("local.sandbox.MainKt")
}

dependencies {
  implementation("dev.petuska:template-kmp-library")
  testImplementation("dev.petuska:test")
}
