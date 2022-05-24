plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "fab"
  dependencies {
    main {
      api(kmdc("ripple"))
      api(kmdc("touch-target"))
    }
  }
}
