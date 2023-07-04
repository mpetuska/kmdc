plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "form-field"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("ripple"))
      }
    }
  }
}
