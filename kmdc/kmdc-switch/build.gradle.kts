plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/switch"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("ripple"))
        api(mdc("switch"))
        api(compose.web.svg)
      }
    }
  }
}
