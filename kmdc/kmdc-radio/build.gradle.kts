plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "radio"
  dependencies {
    main {
      api(kmdc("form-field"))
      api(kmdc("touch-target"))
    }
  }
}
