import ext.NpmWrapperExtension
import ext.PomExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
  id("convention.library")
  id("convention.publishing")
}

val kmdcx = extensions.create("kmdcx", NpmWrapperExtension::class, project)

extensions.configure(PomExtension::class) {
  description by kmdcx.module.map { "Compose Multiplatform Kotlin/JS wrappers for $it" }
}

afterEvaluate {
  extensions.configure(KotlinMultiplatformExtension::class.java) {
    sourceSets.jsMain.configure {
      dependencies {
        api(npm(kmdcx.module.get(), kmdcx.version.get()))
      }
    }
  }
}
