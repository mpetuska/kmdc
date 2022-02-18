import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/data-table"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-checkbox"))
        api(project(":kmdc:kmdc-linear-progress"))
        api(project(":kmdc:kmdc-icon-button"))
        api(npm("@material/data-table", mdcVersion))
      }
    }
  }
}
