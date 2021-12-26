plugins {
  id("plugin.library-mpp")
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
        api(kotlin("test-js"))
        implementation(devNpm("sass", "^1.42.1"))
        implementation(devNpm("sass-loader", "^12.3.0"))
      }
    }
  }
}
