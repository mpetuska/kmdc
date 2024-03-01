plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "list"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(kmdc("ripple"))
        api(kmdc("radio"))
        api(kmdc("checkbox"))
      }
    }
  }
}
