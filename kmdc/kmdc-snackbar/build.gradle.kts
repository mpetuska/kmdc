plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/snackbar"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("button"))
        api(kmdc("icon-button"))
        api(mdc("snackbar"))
      }
    }
  }
}
