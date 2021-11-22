import util.mdcVersion

plugins {
  id("plugin.library-mpp")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(project(":lib:kmdc-core"))
        api(npm("@material/drawer", mdcVersion))
        api(npm("@material/linear-progress", mdcVersion))
        api(npm("@material/textfield", mdcVersion))
        api(npm("@material/checkbox", mdcVersion))
        api(npm("@material/form-field", mdcVersion))
        api(npm("@material/list", mdcVersion))
      }
    }
  }
}
