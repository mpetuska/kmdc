import ext.KmdcExtension
import ext.PomExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
  id("convention.library")
  id("convention.publishing")
}

val kmdc = extensions.create("kmdc", KmdcExtension::class, project)

extensions.configure(PomExtension::class) {
  description by kmdc.module.map { "Compose Multiplatform Kotlin/JS wrappers for $it" }
}

kotlin {
  sourceSets {
    configureEach {
      languageSettings {
        optIn("dev.petuska.kmdc.core.KMDCInternalAPI")
        optIn("dev.petuska.kmdc.core.MDCExternalAPI")
      }
    }
  }
}

afterEvaluate {
  extensions.configure(KotlinMultiplatformExtension::class.java) {
    sourceSets.jsMain.configure {
      dependencies {
        if (project.name != "kmdc-base") api(kmdc("base"))
        api(npm(kmdc.module.get(), kmdc.version.get()))
      }
    }
  }
}
