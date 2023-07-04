plugins {
  alias(libs.plugins.kotlin.js)
  id("convention.common")
  id("convention.ksp")
  id("convention.compose")
  id("convention.versions")
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
      testTask { useKarma() }
    }
  }
  sourceSets {
    main {
      kotlin.srcDir("src/main/showcases")
      dependencies {
        implementation("dev.petuska:kmdc")
        implementation("dev.petuska:kmdcx")
        implementation("dev.petuska:katalog-runtime")
        implementation(libs.compose.routing)
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

/*
Horrifying workaround for https://github.com/google/ksp/issues/367
See also https://kotlinlang.slack.com/archives/C013BA8EQSE/p1674737612683639
 */
afterEvaluate {
  configurations.filter { it.name.startsWith("generatedByKspKotlinJs") && it.name.endsWith("DependenciesMetadata") }
    .forEach { configurations.remove(it) }
}
