import de.fayard.refreshVersions.core.versionFor
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinTest
import java.util.Properties

plugins {
  id("com.diffplug.spotless")
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

spotless {
  val ktlintSettings = mapOf(
    "indent_size" to "2",
    "continuation_indent_size" to "4",
    "disabled_rules" to "no-wildcard-imports,filename"
  )
  kotlin {
    target("src/**/*.kt")
    ktlint(versionFor("version.ktlint")).userData(ktlintSettings)
  }
  kotlinGradle {
    target("*.kts")
    ktlint(versionFor("version.ktlint")).userData(ktlintSettings)
  }
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
