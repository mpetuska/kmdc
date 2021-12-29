import util.mdcVersion

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
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-form-field"))
        api(npm("@material/checkbox", mdcVersion))
      }
    }
  }
}
