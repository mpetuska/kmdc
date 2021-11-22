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
    named("androidMain") { dependencies { api(kotlin("test-junit5")) } }
    named("jvmMain") { dependencies { api(kotlin("test-junit5")) } }
    named("jsMain") { dependencies { api(kotlin("test-js")) } }
  }
}
