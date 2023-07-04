plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "circular-progress"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.html.svg)
      }
    }
  }
}
