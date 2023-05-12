plugins {
  id("com.gradle.enterprise") version "3.13.2"
}

includeBuild("../build-conventions")
includeBuild("../katalog")
includeBuild("..")
