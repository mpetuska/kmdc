import de.fayard.refreshVersions.core.versionFor

plugins {
  id("convention.library")
  id("convention.publishing")
}

description = "Compose Multiplatform Kotlin/JS wrappers for @material/base"

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
        api(npm("@material/base", versionFor("version.npm.material-components-web")))
        api(compose.runtime)
        api(compose.web.core)
      }
    }
  }
}
