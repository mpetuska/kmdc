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
        implementation(kotlin("test"))
        implementation(libs.kotest.assertions.core)
      }
    }
  }
}

tasks {
//  val jsMainClasses = named("jsMainClasses")
//  withType<DokkaTask> { dependsOn(jsMainClasses) }
//  withType<DokkaTaskPartial> { dependsOn(jsMainClasses) }

  register<Jar>("javadocJar") {
    dependsOn(dokkaHtml)
    from(dokkaHtml)
    archiveClassifier by "javadoc"
  }
}
