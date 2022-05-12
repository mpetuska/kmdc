plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "snackbar"
  dependencies {
    main {
      api(kmdc("button"))
      api(kmdc("icon-button"))
    }
  }
}
