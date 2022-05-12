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

afterEvaluate {
  extensions.configure(KotlinMultiplatformExtension::class.java) {
    sourceSets.jsMain.configure {
      dependencies {
        api(kmdc("core"))
        api(npm(kmdc.module.get(), kmdc.version.get()))
      }
    }
  }
}
