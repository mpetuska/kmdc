plugins {
  id("convention.library-js")
  id("convention.publishing")
}

description = "All KMDC extensions"

kotlin {
  sourceSets {
    main {
      dependencies {
        subprojects.forEach(::api)
      }
    }
  }
}
