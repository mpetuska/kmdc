plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "segmented-button"
  dependencies {
    main {
      api(kmdc("ripple"))
    }
  }
}
