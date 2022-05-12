plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "list"
  dependencies {
    main {
      api(kmdc("ripple"))
    }
  }
}
