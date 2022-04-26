import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/tab-indicator"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(npm("@material/tab-indicator", mdcVersion))
      }
    }
  }
}
