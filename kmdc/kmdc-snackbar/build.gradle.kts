plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "snackbar"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("button"))
        api(kmdc("icon-button"))
      }
    }
  }
}
