plugins {
  id("convention.library-js")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.runtime)
        api(compose.html.core)
        implementation(libs.compose.routing)
      }
    }
  }
}
