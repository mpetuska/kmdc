plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "top-app-bar"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("icon-button"))
      }
    }
  }
}
