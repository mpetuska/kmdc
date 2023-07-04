plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "menu"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("list"))
        api(kmdc("menu-surface"))
      }
    }
  }
}
