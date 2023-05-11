plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "base"
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.runtime)
        api(compose.html.core)
      }
    }
  }
}
