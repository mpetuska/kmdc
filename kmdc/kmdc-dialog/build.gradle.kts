plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "dialog"
  dependencies {
    main {
      api(kmdc("button"))
      api(kmdc("icon-button"))
    }
  }
}
