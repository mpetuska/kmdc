import util.Git
plugins {
  id("convention.common")
  id("convention.dokka")
  id("convention.pom")
  `maven-publish`
  signing
}

tasks {
  withType<Jar>().configureEach {
    manifest {
      attributes(
        "Built-By" to GradleVersion.current(),
        "Build-JDK" to System.getProperty("java.version"),
        "Implementation-Version" to project.version,
        "Created-By" to System.getProperty("user.name"),
        "Created-From" to Git.headCommitHash,
      )
    }
  }
  val cleanMavenLocal by registering {
    group = "build"
    doLast {
      val groupRepo =
        file("${System.getProperty("user.home")}/.m2/repository/${project.group.toString().replace(".", "/")}")
      publishing.publications.filterIsInstance<MavenPublication>().forEach {
        groupRepo.resolve(it.artifactId).deleteRecursively()
      }
    }
  }
  named("clean") {
    dependsOn(cleanMavenLocal)
  }
  withType<AbstractPublishToMaven> {
    mustRunAfter(withType<Sign>())
  }
}

signing {
  val signingKey: String? by project
  val signingPassword: String? by project
  if (signingKey != null) {
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
  }
}
