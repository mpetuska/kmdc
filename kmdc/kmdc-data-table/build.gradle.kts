plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/data-table"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(kmdc("checkbox"))
        api(kmdc("linear-progress"))
        api(kmdc("icon-button"))
        api(mdc("data-table"))
      }
    }
  }
}
