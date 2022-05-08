plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/image-list"

kotlin {
  sourceSets {
    commonMain
    jsMain {
      dependencies {
        api(kmdc("core"))
        api(mdc("image-list"))
      }
    }
  }
}
