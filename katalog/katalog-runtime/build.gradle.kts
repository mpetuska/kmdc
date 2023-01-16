plugins {
  id("convention.library")
}

kotlin {
  sourceSets {
    jsMain {
      dependencies {
        api(compose.runtime)
        api(compose.web.core)
        implementation("app.softwork:routing-compose:_")
      }
    }
  }
}
