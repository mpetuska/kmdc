import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(project(":lib:kmdc-core"))
        api(project(":lib:kmdc-ripple"))
        api(npm("@material/list", mdcVersion))
      }
    }
  }
}
