plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/menu-surface"

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(npm("@material/menu-surface", mdcVersion))
      }
    }
  }
}
