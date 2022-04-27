import de.fayard.refreshVersions.core.versionFor

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

description = "Compose Multiplatform Kotlin/JS wrappers for material-icons"

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        val mdcIconsVersion = versionFor("version.npm.material-icons")
        api(project(":kmdc:kmdc-core"))
        api(npm("material-icons", mdcIconsVersion))
      }
    }
  }
}
