plugins {
  id("de.fayard.refreshVersions") version "0.51.0"
  id("com.gradle.enterprise") version "3.12.2"
// //                      # available:"3.12"
// //                      # available:"3.12.1"
// //                      # available:"3.12.2"
// //                      # available:"3.12"
// //                      # available:"3.12.1"
}

rootProject.name = "KMDC"

refreshVersions {
  versionsPropertiesFile = rootDir.resolve("gradle/versions.properties")
  extraArtifactVersionKeyRules(rootDir.resolve("gradle/versions.rules"))
}

fun includeModuleGroup(path: String) {
  rootDir.resolve(path).listFiles { file: File -> file.isDirectory && file.name.startsWith(path) }
    ?.map { ":$path:${it.name}" }?.forEach(::include)?.also { include(":$path") }
}

includeModuleGroup("kmdc")
includeModuleGroup("kmdcx")

includeBuild("build-conventions")
