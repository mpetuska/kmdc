plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "chips"
  dependencies {
    main {
      api(compose.web.svg)
      api(kmdc("touch-target"))
    }
  }
}
