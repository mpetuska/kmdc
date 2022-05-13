plugins {
  id("convention.library")
}

kotlin {
  targets {
    jvm()
    sourceSets {
      commonMain {
        dependencies {
          api(compose.runtime)
        }
      }
    }
  }
  sourceSets {
    jsMain {
      dependencies {
        implementation("app.softwork:routing-compose:_")
      }
    }
  }
}
