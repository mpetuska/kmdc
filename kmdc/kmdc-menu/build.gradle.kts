plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/menu"

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(project(":kmdc:kmdc-list"))
        api(project(":kmdc:kmdc-menu-surface"))
        api(npm("@material/menu", mdcVersion))
      }
    }
  }
}
