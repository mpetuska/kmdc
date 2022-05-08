plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/menu"

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(kmdc("core"))
        api(kmdc("list"))
        api(kmdc("menu-surface"))
        api(mdc("menu"))
      }
    }
  }
}
