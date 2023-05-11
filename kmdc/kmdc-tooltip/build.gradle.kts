plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "tooltip"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("button"))
      }
    }
  }
}
