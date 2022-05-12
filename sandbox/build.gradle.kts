import util.enableSass

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
  id("convention.common")
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
    enableSass(main = true, test = true)
    browser {
      commonWebpackConfig {
        sourceMaps = true
        devServer = devServer?.copy(
          open = false,
          port = 3000,
        )
      }
    }
  }
  sourceSets {
    jsMain {
      kotlin.srcDir("src/jsMain/samples")
      dependencies {
        implementation("dev.petuska:kmdc")
        implementation("dev.petuska:kmdcx")
        implementation("app.softwork:routing-compose:_")
      }
    }
    all {
      languageSettings {
        optIn("kotlin.ExperimentalStdlibApi")
      }
    }
  }
}
