plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "switch"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
        api(compose.html.svg)
      }
    }
  }
}
