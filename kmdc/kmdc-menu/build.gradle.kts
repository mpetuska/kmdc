plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "menu"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("list"))
        api(kmdc("menu-surface"))
      }
    }
  }
}
