plugins {
  id("convention.library")
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        api(compose.runtime)
      }
    }
    jsMain {
      dependencies {
        implementation("app.softwork:routing-compose:_")
      }
    }
  }
}
