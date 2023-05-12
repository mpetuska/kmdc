plugins {
  id("convention.common")
  kotlin("multiplatform")
  id("convention.dokka")
}

kotlin {
  explicitApi()
  jvm {
    compilations["test"].defaultSourceSet {
      dependencies {
        implementation(libs.kotlin.test)
        implementation(libs.kotest.assertions.core)
      }
    }
  }
}

tasks {
  register<Jar>("javadocJar") {
    dependsOn(dokkaHtml)
    from(dokkaHtml)
    archiveClassifier by "javadoc"
  }
}
