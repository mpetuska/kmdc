plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "checkbox"
  dependencies {
    main {
      api(compose.web.svg)
      api(kmdc("form-field"))
      api(kmdc("touch-target"))
    }
  }
}
