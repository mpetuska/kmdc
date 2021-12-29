plugins {
  id("plugin.library-mpp")
  id("plugin.publishing-mpp")
}

description = "All KMDC extensions"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        subprojects.forEach(::api)
      }
    }
  }
}
