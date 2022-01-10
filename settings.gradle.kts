plugins {
  id("de.fayard.refreshVersions") version "0.30.2"
  id("com.gradle.enterprise") version "3.8"
}

refreshVersions { extraArtifactVersionKeyRules(file("versions.rules")) }

rootProject.name = "KMDC"

include(":test")

fun includeModuleGroup(path: String) {
  rootDir.resolve(path).listFiles { file: File -> file.isDirectory && file.name.startsWith(path) }
    ?.map { ":$path:${it.name}" }?.forEach(::include)?.also { include(":$path") }
}

includeModuleGroup("kmdc")
includeModuleGroup("kmdcx")
