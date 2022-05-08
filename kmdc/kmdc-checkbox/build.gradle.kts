plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/checkbox"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.web.svg)
        api(kmdc("core"))
        api(kmdc("form-field"))
        api(kmdc("touch-target"))
        api(mdc("checkbox"))
      }
    }
  }
}
