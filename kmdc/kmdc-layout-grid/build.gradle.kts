plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/layout-grid"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(mdc("layout-grid"))
      }
    }
  }
}
