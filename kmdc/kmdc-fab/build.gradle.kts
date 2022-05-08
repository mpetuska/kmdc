plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/fab"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-ripple"))
        api(npm("@material/fab", mdcVersion))
      }
    }
  }
}
