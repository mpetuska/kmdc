plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "icon-button"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("ripple"))
      }
    }
  }
}
