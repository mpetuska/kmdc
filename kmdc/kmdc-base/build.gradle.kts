plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "base"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.runtime)
        api(libs.compose.html.core)
      }
    }
  }
}
