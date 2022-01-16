pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

plugins {
  id("de.fayard.refreshVersions") version "0.30.2"
  id("com.gradle.enterprise") version "3.8.1"
}

refreshVersions {
  extraArtifactVersionKeyRules(file("versions.rules"))
}

includeBuild("..")
