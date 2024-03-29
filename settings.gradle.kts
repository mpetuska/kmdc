plugins {
  id("com.gradle.enterprise") version "3.16.2"
}

includeBuild("build-conventions")

rootProject.name = "KMDC"

fun includeModuleGroup(path: String) {
  rootDir.resolve(path).listFiles { file: File -> file.isDirectory && file.name.startsWith(path) }
    ?.map { ":$path:${it.name}" }?.forEach(::include)?.also { include(":$path") }
}

includeModuleGroup("kmdc")
includeModuleGroup("kmdcx")
