plugins {
  id("plugin.library-mpp")
  id("plugin.library-compose")
}

description = "Local test utilities"

kotlin {
  explicitApi = null
  sourceSets {
    commonMain {
      dependencies {
        api(kotlin("test"))
        api(kotlin("test-annotations-common"))
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-test:_")
      }
    }
    named("jsMain") {
      dependencies {
        api("dev.petuska:klip:_")
        api(kotlin("test-js"))
      }
    }
  }
}
