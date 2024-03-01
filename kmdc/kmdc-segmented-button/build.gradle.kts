plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "segmented-button"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
      }
    }
  }
}
