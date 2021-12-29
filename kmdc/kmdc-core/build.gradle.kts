plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(compose.runtime)
        api(compose.web.core)
      }
    }
  }
}
