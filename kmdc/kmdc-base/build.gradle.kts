plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "base"
  dependencies {
    main {
      api(compose.runtime)
      api(compose.web.core)
    }
  }
}
