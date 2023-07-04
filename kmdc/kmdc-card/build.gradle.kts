plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "card"
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
