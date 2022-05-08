plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/dialog"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("button"))
        api(mdc("dialog"))
      }
    }
  }
}
