plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "radio"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("form-field"))
        api(kmdc("touch-target"))
      }
    }
  }
}
