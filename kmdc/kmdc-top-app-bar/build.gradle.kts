plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "top-app-bar"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("icon-button"))
      }
    }
  }
}
