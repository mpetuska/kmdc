plugins {
  id("com.gradle.enterprise") version "3.14"
}

includeBuild("../build-conventions")
includeBuild("../katalog")
includeBuild("..")
