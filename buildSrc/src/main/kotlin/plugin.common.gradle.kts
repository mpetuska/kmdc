import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinTest

plugins {
  id("com.diffplug.spotless")
  idea
}

repositories {
  mavenCentral()
  google()
}

idea {
  module {
    isDownloadSources = true
    isDownloadJavadoc = true
  }
}

spotless {
  kotlin { ktfmt() }
  kotlinGradle { ktfmt() }
}

tasks {
  withType<Test> { useJUnitPlatform() }

  afterEvaluate {
    if (tasks.findByName("compile") == null) {
      register("compile") {
        dependsOn(withType(AbstractKotlinCompile::class))
        group = "build"
      }
    }
    if (tasks.findByName("allTests") == null) {
      register("allTests") {
        dependsOn(withType(KotlinTest::class))
        group = "verification"
      }
    }
  }
}
