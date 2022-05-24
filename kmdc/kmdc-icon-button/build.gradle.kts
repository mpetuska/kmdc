plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "icon-button"
  dependencies {
    main {
      api(compose.web.svg)
      api(kmdc("ripple"))
    }
  }
}
