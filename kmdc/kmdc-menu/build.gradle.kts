plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "menu"
  dependencies {
    main {
      api(kmdc("list"))
      api(kmdc("menu-surface"))
    }
  }
}
