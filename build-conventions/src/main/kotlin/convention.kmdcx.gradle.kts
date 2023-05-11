import ext.*

plugins {
  id("convention.library-js")
  id("convention.publishing")
}

val kmdcx = extensions.create<NpmWrapperExtension>("kmdcx")

extensions.configure(PomExtension::class) {
  description by kmdcx.module.map { "Compose Multiplatform Kotlin/JS wrappers for $it" }
}

kotlin {
  js {
    compilations["main"].defaultSourceSet {
      dependencies {
        api(kmdc("base"))
        afterEvaluate { api(npm(kmdcx.module.get(), kmdcx.version.get())) }
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
