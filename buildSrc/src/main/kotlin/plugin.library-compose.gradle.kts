plugins {
  id("plugin.library-mpp")
  id("org.jetbrains.compose")
}

kotlin {
  sourceSets {
    all {
      languageSettings {
        optIn("dev.petuska.kmdc.core.MDCInternalDsl")
        optIn("kotlin.RequiresOptIn")
      }
    }
    jsTest {
      dependencies {
        implementation(compose.web.testUtils)
      }
      languageSettings {
        optIn("org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi")
      }
    }
  }
}
