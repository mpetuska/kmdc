plugins {
  id("plugin.library-mpp")
  id("plugin.publishing-mpp")
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
