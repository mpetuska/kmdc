plugins {
  id("convention.library")
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
