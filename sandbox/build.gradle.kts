import util.enableSass

plugins {
  kotlin("multiplatform")
  id("convention.compose")
  id("convention.common")
  id("convention.ksp")
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
      kotlin.srcDir(buildDir.resolve("generated/ksp/js/jsMain/kotlin"))
      dependencies {
        implementation("dev.petuska:kmdc")
        implementation("dev.petuska:kmdcx")
        implementation("dev.petuska:katalog-runtime")
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

dependencies {
  "kspJs"("dev.petuska:katalog-ksp")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}
