import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType
import util.enableSCSS

plugins {
  id("convention.common")
  kotlin("multiplatform")
  id("convention.dokka")
  id("convention.compose")
}

kotlin {
  explicitApi()
  js(KotlinJsCompilerType.IR) {
    useCommonJs()
    enableSCSS(main = false, test = true)
    browser {
      testTask {
        useKarma {
          when (project.properties["kotlin.js.test.browser"]) {
            "firefox" -> useFirefox()
            "firefox-headless" -> useFirefoxHeadless()
            "firefox-developer" -> useFirefoxDeveloper()
            "firefox-developer-headless" -> useFirefoxDeveloperHeadless()
            "chrome" -> useChrome()
            "chrome-headless" -> useChromeHeadless()
            "chromium" -> useChromium()
            "chromium-headless" -> useChromiumHeadless()
            "safari" -> useSafari()
            "opera" -> useOpera()
            else -> usePhantomJS()
          }
        }
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
