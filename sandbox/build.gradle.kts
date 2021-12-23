plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

description = "Local consumer sandbox"

repositories {
  mavenCentral()
  google()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

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
