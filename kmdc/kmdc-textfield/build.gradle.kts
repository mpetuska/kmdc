plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "textfield"
  dependencies {
    main {
      api(kmdc("ripple"))
      api(kmdc("line-ripple"))
      api(kmdc("floating-label"))
      api(kmdc("notched-outline"))
    }
  }
}
