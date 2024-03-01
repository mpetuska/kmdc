plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "form-field"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
      }
    }
  }
}
