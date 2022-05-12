plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "button"
  dependencies {
    main {
      api(compose.web.svg)
      api(kmdc("ripple"))
      api(kmdc("touch-target"))
      api(kmdc("elevation"))
    }
  }
}
