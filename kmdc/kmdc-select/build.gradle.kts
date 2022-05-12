plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "select"
  dependencies {
    main {
      api(kmdc("list"))
      api(kmdc("menu-surface"))
      api(compose.web.svg)
    }
  }
}
