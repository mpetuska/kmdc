plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/chips"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.web.svg)
        api(project(":kmdc:kmdc-core"))
        api(npm("@material/chips", mdcVersion))
      }
    }
  }
}
