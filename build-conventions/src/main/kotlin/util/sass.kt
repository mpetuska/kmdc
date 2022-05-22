package util

import jsMain
import jsTest
import org.gradle.api.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*
import org.jetbrains.kotlin.gradle.targets.js.dsl.*

fun KotlinJsTargetDsl.enableSass(main: Boolean, test: Boolean) {
  browser {
    commonWebpackConfig {
      cssSupport.enabled = true
      configDirectory = project.rootDir.resolve("gradle/webpack.config.d")
    }
    project.extensions.configure(KotlinMultiplatformExtension::class.java) {
      val targetSourceSets = mutableListOf<NamedDomainObjectProvider<KotlinSourceSet>>()
      if (main) targetSourceSets.add(sourceSets.jsMain)
      if (test) targetSourceSets.add(sourceSets.jsTest)
      targetSourceSets.forEach {
        it.configure {
          dependencies {
            implementation(devNpm("sass", "^1.42.1"))
            implementation(devNpm("sass-loader", "^12.3.0"))
          }
        }
      }
    }
  }
}
