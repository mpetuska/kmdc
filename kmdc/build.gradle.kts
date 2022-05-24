plugins {
  id("convention.library")
  id("convention.publishing")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/material-components-web"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        subprojects.forEach(::api)
      }
    }
  }
}
