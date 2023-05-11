import io.gitlab.arturbosch.detekt.Detekt

plugins {
  id("io.gitlab.arturbosch.detekt")
}

dependencies {
  detektPlugins(libs.detekt.formatting)
}

detekt {
  config.from(rootDir.resolve("gradle/detekt.yml"))
  buildUponDefaultConfig = true
  source.from("src/", "*.kts")
}

tasks {
  if (project == rootProject) {
    register("detektAll", Detekt::class) {
      description = "Run Detekt for all modules"
      config.from(project.detekt.config)
      buildUponDefaultConfig = project.detekt.buildUponDefaultConfig
      setSource(files(projectDir))
    }
  }
  withType<Detekt> {
    parallel = true
    reports {
      // observe findings in your browser with structure and code snippets
      html.required by true
      // checkstyle like format mainly for integrations like Jenkins
      xml.required by true
      // similar to the console output, contains issue signature to manually edit baseline files
      txt.required by true
      // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
      sarif.required by true
    }
    include("**/*.kt", "**/*.kts")
    exclude("**/build", "scripts/")
  }
}
