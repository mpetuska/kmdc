plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "data-table"
}

kotlin {
  sourceSets {
    main {
      dependencies {
        api(kmdc("checkbox"))
        api(kmdc("linear-progress"))
        api(kmdc("icon-button"))
      }
    }
  }
}
