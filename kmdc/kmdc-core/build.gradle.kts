plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Core internal KMDC utilities"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.runtime)
        api(compose.web.core)
      }
    }
  }
}
