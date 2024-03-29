plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "button"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("ripple"))
        api(kmdc("touch-target"))
        api(kmdc("elevation"))
      }
    }
  }
}
