import util.by

plugins {
  id("plugin.common")
  id("io.github.gradle-nexus.publish-plugin")
}

nexusPublishing {
  repositories {
    sonatype {
      nexusUrl by uri("https://s01.oss.sonatype.org/service/local/")
      snapshotRepositoryUrl by uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
  }
}
