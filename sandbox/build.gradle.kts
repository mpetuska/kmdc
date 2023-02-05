plugins {
  kotlin("multiplatform")
  id("convention.common")
  id("convention.compose")
  id("convention.ksp")
}

kotlin {
  js {
    binaries.executable()
    useCommonJs()
    browser {
      commonWebpackConfig {
        cssSupport { enabled.set(true) }
        scssSupport { enabled.set(true) }
        devServer = devServer?.copy(
          open = false,
          port = 3000,
        )
      }
      runTask {
        sourceMaps = true
      }
    }
  }
  sourceSets {
    jsMain {
      kotlin.srcDir("src/jsMain/showcases")
      dependencies {
        implementation("dev.petuska:kmdc")
        implementation("dev.petuska:kmdcx")
        implementation("dev.petuska:katalog-runtime")
        implementation("app.softwork:routing-compose:_")
      }
    }
    configureEach {
      languageSettings {
        optIn("kotlin.RequiresOptIn")
        optIn("kotlin.ExperimentalStdlibApi")
      }
    }
  }
}

ksp {
  arg("katalog.contentRoot", rootDir.parentFile.absolutePath)
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
