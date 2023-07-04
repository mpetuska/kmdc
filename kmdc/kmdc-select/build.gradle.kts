plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "select"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(libs.compose.html.svg)
        api(kmdc("list"))
        api(kmdc("menu"))
        api(kmdc("line-ripple"))
        api(kmdc("floating-label"))
        api(kmdc("notched-outline"))
      }
    }
  }
}
