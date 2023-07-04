plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "switch"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("ripple"))
        api(libs.compose.html.svg)
      }
    }
  }
}
