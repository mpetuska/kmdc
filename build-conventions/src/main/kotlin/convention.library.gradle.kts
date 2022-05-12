import gradle.kotlin.dsl.accessors._b1fd2989f539727f21a36273f4d9ae23.dokkaHtml
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import util.enableSass

plugins {
  id("convention.common")
  kotlin("multiplatform")
  id("convention.compose")
}

kotlin {
  explicitApi()
  js {
    useCommonJs()
    enableSass(main = false, test = true)
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
    all {
      languageSettings {
        optIn("dev.petuska.kmdc.core.KMDCInternalAPI")
        optIn("dev.petuska.kmdc.core.MDCExternalAPI")
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
