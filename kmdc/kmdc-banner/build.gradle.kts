plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/switch"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-button"))
        api(npm("@material/banner", mdcVersion))
//        api(compose.web.svg)
      }
    }
  }
}
