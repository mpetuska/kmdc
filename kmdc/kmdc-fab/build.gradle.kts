plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "fab"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("touch-target"))
      }
    }
  }
}
