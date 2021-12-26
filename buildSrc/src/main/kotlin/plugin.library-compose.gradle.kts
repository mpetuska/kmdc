plugins {
  id("plugin.library-mpp")
  id("org.jetbrains.compose")
}

kotlin {
  sourceSets {
    named("jsTest") {
      dependencies {
        implementation(compose.web.testUtils)
      }
      languageSettings {
        optIn("org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi")
      }
    }
  }
}
