import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/select"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-list"))
        api(project(":kmdc:kmdc-menu-surface"))
        api(npm("@material/select", mdcVersion))
        api(compose.web.svg)
      }
    }
  }
}
