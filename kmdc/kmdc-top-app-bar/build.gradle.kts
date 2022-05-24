plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "top-app-bar"
  dependencies {
    main {
      api(kmdc("icon-button"))
    }
  }
}
