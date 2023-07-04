plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "dialog"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("button"))
        api(kmdc("icon-button"))
      }
    }
  }
}
