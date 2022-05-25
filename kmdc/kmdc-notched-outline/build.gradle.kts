plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "notched-outline"
  dependencies {
    main {
      api(kmdc("floating-label"))
    }
  }
}
