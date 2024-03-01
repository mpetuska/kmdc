plugins {
  id("convention.library-js")
  id("convention.publishing")
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
