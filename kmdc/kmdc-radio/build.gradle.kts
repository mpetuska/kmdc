plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "radio"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("form-field"))
        api(kmdc("touch-target"))
      }
    }
  }
}
