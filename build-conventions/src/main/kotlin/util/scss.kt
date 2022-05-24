package util

import jsMain
import jsTest
import org.gradle.api.NamedDomainObjectProvider
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

fun KotlinJsTargetDsl.enableSCSS(main: Boolean, test: Boolean) {
  browser {
    commonWebpackConfig {
      configDirectory = project.rootDir.resolve("gradle/webpack.config.d")
    }
    project.extensions.configure(KotlinMultiplatformExtension::class.java) {
      val targetSourceSets = mutableListOf<NamedDomainObjectProvider<KotlinSourceSet>>()
      if (main) targetSourceSets.add(sourceSets.jsMain)
      if (test) targetSourceSets.add(sourceSets.jsTest)
      targetSourceSets.forEach {
        it.configure {
          dependencies {
            implementation(devNpm("style-loader", "^3.3.1"))
            implementation(devNpm("css-loader", "^6.7.1"))
            implementation(devNpm("sass-loader", "^13.0.0"))
            implementation(devNpm("sass", "^1.52.1"))
          }
        }
      }
    }
  }
}
