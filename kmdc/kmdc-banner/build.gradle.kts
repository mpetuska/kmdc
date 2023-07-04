plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "banner"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("button"))
      }
    }
  }
}
