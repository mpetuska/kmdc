plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "checkbox"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("form-field"))
        api(kmdc("touch-target"))
      }
    }
  }
}
