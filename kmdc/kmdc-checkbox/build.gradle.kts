plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "checkbox"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.html.svg)
        api(kmdc("form-field"))
        api(kmdc("touch-target"))
      }
    }
  }
}
