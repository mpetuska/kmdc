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
        api(kmdc("core"))
        api(mdc("tab-indicator"))
        api(mdc("tab"))
        api(mdc("tab-scroller"))
        api(mdc("tab-bar"))
      }
    }
  }
}
