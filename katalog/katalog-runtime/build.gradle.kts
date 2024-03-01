plugins {
  id("convention.library-js")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(libs.compose.runtime)
        api(libs.compose.html.core)
        implementation(libs.compose.routing)
      }
    }
  }
}
