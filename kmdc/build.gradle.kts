plugins {
  id("convention.library-js")
  id("convention.publishing")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/material-components-web"

kotlin {
  sourceSets {
    main {
      dependencies {
        subprojects.forEach(::api)
      }
    }
  }
}
