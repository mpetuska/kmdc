plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "form-field"
  dependencies {
    main {
      api(kmdc("ripple"))
    }
  }
}
