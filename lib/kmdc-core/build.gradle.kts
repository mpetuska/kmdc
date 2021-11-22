import util.mdcVersion

plugins {
  id("plugin.library-mpp")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    named("jsMain") {
      dependencies {
        api(npm("@material/ripple", mdcVersion))
        api(npm("@material/button", mdcVersion))
        api(npm("@material/icon-button", mdcVersion))
        api(npm("@material/top-app-bar", mdcVersion))
        api(npm("@material/chips", mdcVersion))
        api(npm("@material/card", mdcVersion))
        api(npm("@material/typography", mdcVersion))
        api(npm("@material/layout-grid", mdcVersion))
        api(npm("@material/drawer", mdcVersion))
        api(npm("@material/linear-progress", mdcVersion))
        api(npm("@material/textfield", mdcVersion))
        api(npm("@material/checkbox", mdcVersion))
        api(npm("@material/form-field", mdcVersion))
        api(npm("@material/list", mdcVersion))
        api(compose.web.core)
        api(compose.runtime)
      }
    }
  }
}
