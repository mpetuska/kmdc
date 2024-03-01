plugins {
  id("convention.common")
  kotlin("multiplatform")
  id("convention.dokka")
  id("convention.compose")
}

kotlin {
  explicitApi()
  js {
    useCommonJs()
    browser {
      commonWebpackConfig {
        cssSupport { enabled by true }
        scssSupport { enabled by true }
      }
      testTask {
        useKarma()
      }
    }
    compilations["test"].defaultSourceSet {
      dependencies {
        implementation(compose.html.testUtils)
        implementation(libs.kotlin.test)
        implementation(libs.kotest.assertions.core)
      }
      languageSettings {
        optIn("org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi")
      }
    }
  }
}

tasks {
  register<Jar>("javadocJar") {
    dependsOn(dokkaHtml)
    from(dokkaHtml)
    archiveClassifier by "javadoc"
  }
}
