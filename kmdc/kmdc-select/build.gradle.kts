plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "select"
  dependencies {
    main {
      api(compose.web.svg)
      api(kmdc("list"))
      api(kmdc("menu"))
      api(kmdc("line-ripple"))
    }
  }
}
