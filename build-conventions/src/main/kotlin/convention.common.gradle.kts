import de.fayard.refreshVersions.core.*
import org.jetbrains.kotlin.gradle.tasks.*
import java.util.*

plugins {
  id("io.gitlab.arturbosch.detekt")
  idea
}

rootDir.resolve("local.properties").takeIf(File::exists)?.let {
  Properties().apply {
    it.inputStream().use(::load)
  }.mapKeys { (k, _) -> k.toString() }
}?.toList()?.forEach { (k, v) ->
  project.extra[k] = v
}

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

idea {
  module {
    isDownloadSources = true
    isDownloadJavadoc = true
  }
}

dependencies {
  detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:_")
}

detekt {
  config.from(rootDir.resolve("gradle/detekt.yml"))
  buildUponDefaultConfig = true
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
