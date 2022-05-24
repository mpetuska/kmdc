plugins {
  id("convention.kmdcx")
}

kmdcx {
  module by "material-icons"
  versionKey by "version.npm.material-icons"
  dependencies {
    main {
      api(kmdc("base"))
    }
  }
}
