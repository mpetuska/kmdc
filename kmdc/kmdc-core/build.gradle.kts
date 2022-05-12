plugins {
  id("convention.library")
  id("convention.publishing")
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
