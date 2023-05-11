plugins {
  `kotlin-dsl`
  alias(libs.plugins.versions)
  alias(libs.plugins.versions.update)
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation(libs.plugin.kotlin)
  implementation(libs.plugin.compose)
  implementation(libs.plugin.dokka)
  implementation(libs.plugin.git.hooks)
  implementation(libs.plugin.detekt)
  implementation(libs.plugin.publish)
  implementation(libs.plugin.ksp)

  implementation(libs.plugin.versions)
  implementation(libs.plugin.versions.update)
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

versionCatalogUpdate {
  keep {
    keepUnusedVersions.set(true)
    keepUnusedLibraries.set(true)
    keepUnusedPlugins.set(true)
  }
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}
