plugins {
  id("com.gradle.enterprise") version "3.13"
}

includeBuild("../build-conventions")

include(
  ":katalog-ksp",
  ":katalog-runtime",
)
