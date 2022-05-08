plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/button"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("ripple"))
        api(mdc("button"))
      }
    }
  }
}
