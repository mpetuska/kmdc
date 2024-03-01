plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "dialog"
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
