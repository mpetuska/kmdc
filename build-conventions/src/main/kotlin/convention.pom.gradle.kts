import ext.PomExtension
import util.Git

plugins {
  `maven-publish`
}

val pomExt: PomExtension = extensions.create<PomExtension>("pom", project)

val owner = pomExt.owner
val repoPath = owner.id.zip(owner.repo) { id, repo -> "$id/$repo" }
publishing {
  repositories {
    maven(repoPath.map { "https://maven.pkg.github.com/$it" }) {
      name = "GitHub"
      credentials {
        username = System.getenv("GH_USERNAME")
        password = System.getenv("GH_PASSWORD")
      }
    }
    maven("file://${rootProject.buildDir}/localMaven") {
      name = "Local"
    }
  }
  publications {
    withType<MavenPublication> {
      artifact(tasks["javadocJar"])
      pom {
        name by pomExt.name
        url by repoPath.map { "https://github.com/$it" }
        description by pomExt.description

        licenses {
          license {
            name by "The Apache License, Version 2.0"
            url by "https://www.apache.org/licenses/LICENSE-2.0.txt"
          }
        }

        developers {
          developer {
            id by owner.id
            name by owner.name
            email by owner.email
          }
        }

        scm {
          connection by repoPath.map { "scm:git:git://github.com:$it.git" }
          developerConnection by repoPath.map { "scm:git:git@github.com:$it.git" }
          url by repoPath.map { "https://github.com/$it.git" }
          tag by Git.headCommitHash
        }
      }
    }
  }
}

tasks {
  register("publishToLocal") {
    dependsOn("publishAllPublicationsToLocalRepository")
  }
}
