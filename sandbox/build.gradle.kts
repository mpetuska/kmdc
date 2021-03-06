import util.enableSCSS

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
    enableSCSS(main = true, test = true)
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
      kotlin.srcDir("src/jsMain/showcases")
      kotlin.srcDir(buildDir.resolve("generated/ksp/js/jsMain/kotlin"))
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

dependencies {
  "kspJs"("dev.petuska:katalog-ksp")
}

ksp {
  arg("katalog.contentRoot", rootDir.parentFile.absolutePath)
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}
