import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
  id("convention.common")
  kotlin("multiplatform")
  id("convention.dokka")
  id("convention.compose")
}

kotlin {
  explicitApi()
  js(IR) {
    useCommonJs()
    browser {
      commonWebpackConfig {
        cssSupport { enabled.set(true) }
        scssSupport { enabled.set(true) }
      }
      testTask {
        useKarma()
      }
    }
  }

  sourceSets {
    configureEach {
      languageSettings {
        optIn("kotlin.RequiresOptIn")
      }
    }
    jsTest {
      dependencies {
        implementation(compose.web.testUtils)
        implementation(kotlin("test-js"))
        implementation("io.kotest:kotest-assertions-core:_")
      }
      languageSettings {
        optIn("org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi")
      }
    }
  }
}

tasks {
  val jsMainClasses by getting
  withType<DokkaTask>().configureEach { dependsOn(jsMainClasses) }
  withType<DokkaTaskPartial>().configureEach { dependsOn(jsMainClasses) }

  register<Jar>("javadocJar") {
    dependsOn(dokkaHtml)
    from(dokkaHtml)
    archiveClassifier.set("javadoc")
  }
}
