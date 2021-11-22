plugins { id("plugin.library-mpp") }

description = "Local test utilities"

kotlin {
  explicitApi = null
  sourceSets {
    commonMain {
      dependencies {
        api(kotlin("test"))
        api(kotlin("test-annotations-common"))
        api("dev.petuska:klip:_")
      }
    }
    named("jsMain") {
      dependencies {
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
        api(kotlin("test-js"))
      }
    }
  }
}
