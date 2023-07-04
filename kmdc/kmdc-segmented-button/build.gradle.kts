plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "segmented-button"
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
