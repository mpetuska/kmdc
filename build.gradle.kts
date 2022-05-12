plugins {
  if (System.getenv("CI") == null) {
    id("convention.git-hooks")
  }
  id("convention.publishing-nexus")
  id("convention.dokka")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}
