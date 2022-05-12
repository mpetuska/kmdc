plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "switch"
  dependencies {
    main {
      api(kmdc("ripple"))
      api(compose.web.svg)
    }
  }
}
