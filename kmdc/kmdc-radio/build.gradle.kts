plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/radio"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("form-field"))
        api(mdc("radio"))
      }
    }
  }
}
