plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/line-ripple"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(mdc("line-ripple"))
      }
    }
  }
}
