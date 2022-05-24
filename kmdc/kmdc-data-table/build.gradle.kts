plugins {
  id("convention.kmdc")
}

kmdc {
  mdc by "data-table"
  dependencies {
    main {
      api(kmdc("checkbox"))
      api(kmdc("linear-progress"))
      api(kmdc("icon-button"))
    }
  }
}
