plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "circular-progress"
  dependencies {
    main {
      api(compose.web.svg)
    }
  }
}
