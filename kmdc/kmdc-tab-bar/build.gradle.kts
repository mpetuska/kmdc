plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/tab-bar"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(npm("@material/tab-indicator", mdcVersion))
        api(npm("@material/tab", mdcVersion))
        api(npm("@material/tab-scroller", mdcVersion))
        api(npm("@material/tab-bar", mdcVersion))
      }
    }
  }
}
