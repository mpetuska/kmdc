plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/tooltip"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-ripple"))
        api(project(":kmdc:kmdc-button"))
        api(npm("@material/tooltip", mdcVersion))
      }
    }
  }
}
