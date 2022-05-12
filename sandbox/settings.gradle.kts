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
}

refreshVersions {
  versionsPropertiesFile = rootDir.resolve("gradle/versions.properties")
}

includeBuild("../build-conventions")
includeBuild("..")
