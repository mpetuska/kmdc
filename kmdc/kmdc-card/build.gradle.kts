plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/card"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-button"))
        api(project(":kmdc:kmdc-icon-button"))
        api(npm("@material/card", mdcVersion))
      }
    }
  }
}
