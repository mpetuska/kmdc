plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "textfield"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("line-ripple"))
        api(kmdc("floating-label"))
        api(kmdc("notched-outline"))
      }
    }
  }
}
