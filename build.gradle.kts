plugins {
  if (System.getenv("CI") == null) {
    id("convention.git-hooks")
  }
  id("convention.publishing-nexus")
  id("convention.dokka")
  id("convention.common")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

tasks.register("detektAll", io.gitlab.arturbosch.detekt.Detekt::class) {
  description = "Run Detekt for all modules"
  config.from(detekt.config)
  buildUponDefaultConfig = detekt.buildUponDefaultConfig
  setSource(files(projectDir))
  include("**/*.kt", "**/*.kts")
  exclude("**/build", "scripts/")
}
