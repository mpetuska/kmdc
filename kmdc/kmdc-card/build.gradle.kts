plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "card"
  dependencies {
    main {
      api(kmdc("button"))
      api(kmdc("icon-button"))
    }
  }
}
