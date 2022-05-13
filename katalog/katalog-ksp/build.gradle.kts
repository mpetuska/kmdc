plugins {
  id("convention.common")
  kotlin("jvm")
  id("com.github.gmazzo.buildconfig")
}

dependencies {
  compileOnly("com.google.devtools.ksp:symbol-processing-api:_")
  implementation(project(":katalog-runtime"))
  implementation("com.squareup:kotlinpoet-ksp:_")

  testImplementation(kotlin("reflect"))
  testImplementation(kotlin("test-junit5"))
  testImplementation(kotlin("compiler-embeddable"))
  testImplementation("com.github.tschuchortdev:kotlin-compile-testing:_")
}

kotlin {
  sourceSets {
    configureEach {
      languageSettings {
        optIn("com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview")
      }
    }
  }
}

buildConfig {
  useKotlinOutput {
    internalVisibility = true
    topLevelConstants = true
  }
  packageName("dev.petuska.katalog.plugin.config")
  buildConfigField("String", "GROUP", "\"${rootProject.group}\"")
  buildConfigField("String", "NAME", "\"${rootProject.name}\"")
  buildConfigField("String", "VERSION", "\"${rootProject.version}\"")
}
