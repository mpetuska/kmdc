import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinNativeCompile
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import org.jetbrains.kotlin.konan.target.HostManager
import util.buildHost

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("plugin.common")
//  id("dev.petuska.klip")
}

kotlin {
  explicitApi()
  js {
    useCommonJs()
    browser {
      commonWebpackConfig {
        cssSupport.enabled = true
        configDirectory = rootDir.resolve("sandbox/webpack.config.d")
      }
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
    commonTest {
      dependencies {
        implementation(kotlin("test"))
      }
    }
  }
}

tasks {
  withType<CInteropProcess> { onlyIf { konanTarget.buildHost == HostManager.host.family } }
  withType<AbstractKotlinNativeCompile<*, *>> {
    onlyIf { compilation.konanTarget.buildHost == HostManager.host.family }
  }
}
