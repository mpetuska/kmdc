plugins {
  kotlin("multiplatform") version "1.6.10"
  id("org.jetbrains.compose") version "1.0.1-rc2"
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
