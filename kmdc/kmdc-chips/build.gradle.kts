plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "chips"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("touch-target"))
      }
    }
  }
}
