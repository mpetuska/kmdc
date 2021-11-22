plugins { `kotlin-dsl` }

repositories {
  gradlePluginPortal()
  mavenCentral()
  google()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
  implementation("com.android.library:com.android.library.gradle.plugin:_")
  implementation("org.jetbrains.dokka:dokka-gradle-plugin:_")
  implementation("org.jetbrains.kotlin:kotlin-serialization:_")
  implementation("com.github.jakemarsden:git-hooks-gradle-plugin:_")
  implementation("com.diffplug.spotless:spotless-plugin-gradle:_")
  implementation("io.github.gradle-nexus:publish-plugin:_")
  implementation("dev.petuska:klip-gradle-plugin:_")
}
