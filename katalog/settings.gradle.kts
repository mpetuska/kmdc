pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

plugins {
  id("de.fayard.refreshVersions") version "0.40.1"
  id("com.gradle.enterprise") version "3.8.1"
////                      # available:"3.9"
////                      # available:"3.10"
}

refreshVersions {
  versionsPropertiesFile = rootDir.resolve("gradle/versions.properties")
}

includeBuild("../build-conventions")

include(
  ":katalog-gradle-plugin",
  ":katalog-kotlin-plugin",
  ":katalog-runtime",
)
