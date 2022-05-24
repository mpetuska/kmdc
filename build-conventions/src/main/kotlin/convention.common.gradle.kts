import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinTest
import java.util.Properties

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
  source = files("src/jsMain/", "src/jsTest")
}

tasks {
  withType<Test> { useJUnitPlatform() }
  afterEvaluate {
    withType<Detekt>().configureEach {
      parallel = true
      reports {
        // observe findings in your browser with structure and code snippets
        html.required.set(true)
        // checkstyle like format mainly for integrations like Jenkins
        xml.required.set(true)
        // similar to the console output, contains issue signature to manually edit baseline files
        txt.required.set(true)
        // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
        sarif.required.set(true)
      }
    }
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
