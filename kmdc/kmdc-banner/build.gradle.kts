plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "banner"
  dependencies {
    main {
      api(kmdc("button"))
    }
  }
}
