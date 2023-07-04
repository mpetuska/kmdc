plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "icon-button"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("ripple"))
      }
    }
  }
}
