import util.mdcVersion

plugins {
  id("plugin.library-compose")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(compose.web.svg)
        api(project(":lib:kmdc-core"))
        api(project(":lib:kmdc-form-field"))
        api(npm("@material/checkbox", mdcVersion))
      }
    }
  }
}
