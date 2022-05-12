plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "icon-button"
  dependencies {
    main {
      api(kmdc("ripple"))
    }
  }
}
