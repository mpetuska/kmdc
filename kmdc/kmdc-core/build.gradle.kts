plugins {
  id("convention.library")
  id("convention.publishing")
}

description = "Core internal KMDC utilities"

kotlin {
  sourceSets {
    configureEach {
      languageSettings {
        optIn("dev.petuska.kmdc.core.KMDCInternalAPI")
        optIn("dev.petuska.kmdc.core.MDCExternalAPI")
      }
    }
    jsMain {
      dependencies {
        api(compose.runtime)
        api(compose.web.core)
      }
    }
  }
}
