plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "fab"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("touch-target"))
      }
    }
  }
}
