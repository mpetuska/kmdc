plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "tooltip"
  dependencies {
    main {
      api(kmdc("ripple"))
      api(kmdc("button"))
    }
  }
}
