plugins {
  id("com.google.devtools.ksp")
  idea
}

idea {
  module {
    sourceDirs = sourceDirs + buildDir.resolve("generated/ksp/js/jsMain/kotlin")
    generatedSourceDirs = generatedSourceDirs + buildDir.resolve("generated/ksp/js/jsMain/kotlin")
  }
}
