plugins {
  id("convention.local-properties")
  id("convention.detekt")
  idea
}

repositories {
  mavenCentral()
  google()
  if (findProperty("project.enableSnapshots") == "true") {
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

idea {
  module {
    isDownloadSources = true
    isDownloadJavadoc = true
  }
}

afterEvaluate {
  tasks {
    if (findByName("compile") == null) {
      register("compile") {
        dependsOn(withType(AbstractCompile::class))
        group = "build"
      }
    }
    if (findByName("allTests") == null) {
      register("allTests") {
        dependsOn(withType(AbstractTestTask::class))
        group = "verification"
      }
    }
  }
}
