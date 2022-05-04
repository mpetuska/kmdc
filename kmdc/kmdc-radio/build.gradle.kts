plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/radio"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-form-field"))
        api(npm("@material/radio", mdcVersion))
      }
    }
  }
}
