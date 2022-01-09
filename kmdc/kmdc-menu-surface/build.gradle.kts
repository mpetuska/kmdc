import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(project(":kmdc:kmdc-core"))
        api(npm("@material/menu-surface", mdcVersion))
      }
    }
  }
}
