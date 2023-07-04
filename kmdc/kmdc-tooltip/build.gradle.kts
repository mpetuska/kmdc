plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "tooltip"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("button"))
      }
    }
  }
}
