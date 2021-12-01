plugins {
  if (System.getenv("CI") == null) {
    id("plugin.git-hooks")
  }
  id("plugin.library-compose")
  id("plugin.publishing-nexus")
  id("plugin.publishing-mpp")
  id("plugin.yarn-lock-validation")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

kotlin {
  sourceSets {
    jsMain {
      dependencies { subprojects.filter { it.path.startsWith(":lib:") }.forEach { api(it) } }
    }
  }
}
