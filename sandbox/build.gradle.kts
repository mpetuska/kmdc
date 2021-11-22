import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  kotlin("multiplatform") version "1.5.31"
  id("org.jetbrains.compose") version "1.0.0-rc1"
}

repositories {
  mavenCentral()
  google()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

description = "Local consumer sandbox"

kotlin {
  js {
    binaries.executable()
    useCommonJs()
    browser {
      commonWebpackConfig {
        cssSupport.enabled = true
        sourceMaps = false
        devServer = devServer?.copy(
          open = false,
          port = 3000,
        )
      }
    }
  }
  sourceSets {
    named("commonTest") {
      dependencies {
        implementation("dev.petuska:test")
      }
    }
    named("jsMain") {
      dependencies {
        implementation("dev.petuska:kmdc")
      }
    }
  }
}

// Workaround for https://kotlinlang.slack.com/archives/C0B8L3U69/p1633590092096600
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
  rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().apply {
    resolution("@webpack-cli/serve", "1.5.2")
  }
}
