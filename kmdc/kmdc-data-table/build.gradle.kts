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
        api(npm("@material/data-table", mdcVersion))
      }
    }
  }
}
