plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "banner"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("button"))
      }
    }
  }
}
