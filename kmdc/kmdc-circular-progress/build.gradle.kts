plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "circular-progress"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(libs.compose.html.svg)
      }
    }
  }
}
