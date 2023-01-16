import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("convention.common")
  kotlin("jvm")
  id("com.github.gmazzo.buildconfig")
}

dependencies {
  compileOnly("com.google.devtools.ksp:symbol-processing-api:_")
  implementation("com.squareup:kotlinpoet-ksp:_")
}

java {
  targetCompatibility = JavaVersion.VERSION_11
}

tasks {
  withType<KotlinCompile> {
    compilerOptions {
      jvmTarget.set(JvmTarget.fromTarget(java.targetCompatibility.toString()))
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
