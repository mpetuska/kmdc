plugins {
  id("com.gradle.enterprise") version "3.14"
}

includeBuild("../build-conventions")

include(
  ":katalog-ksp",
  ":katalog-runtime",
)
