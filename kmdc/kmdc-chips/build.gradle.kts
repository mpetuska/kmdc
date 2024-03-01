plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "chips"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("touch-target"))
      }
    }
  }
}
