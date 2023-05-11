import ext.KmdcExtension
import ext.PomExtension

plugins {
  id("convention.library-js")
  id("convention.publishing")
}

val kmdc = extensions.create<KmdcExtension>("kmdc", project)

extensions.configure(PomExtension::class) {
  description by kmdc.module.map { "Compose Multiplatform Kotlin/JS wrappers for $it" }
}

kotlin {
  js {
    compilations["main"].defaultSourceSet {
      dependencies {
        if (!project.name.endsWith("base")) api(kmdc("base"))
        afterEvaluate { api(npm(kmdc.module.get(), kmdc.version.get())) }
      }
    }
  }
  sourceSets {
    configureEach {
      languageSettings {
        optIn("dev.petuska.kmdc.core.KMDCInternalAPI")
        optIn("dev.petuska.kmdc.core.MDCExternalAPI")
      }
    }
  }
}
