pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

plugins {
  id("de.fayard.refreshVersions") version "0.51.0"
  id("com.gradle.enterprise") version "3.12.2"
// //                      # available:"3.12"
// //                      # available:"3.12.1"
// //                      # available:"3.12.2"
// //                      # available:"3.12"
// //                      # available:"3.12.1"
}

refreshVersions {
  versionsPropertiesFile = rootDir.resolve("gradle/versions.properties")
  extraArtifactVersionKeyRules(rootDir.resolve("gradle/versions.rules"))
}
