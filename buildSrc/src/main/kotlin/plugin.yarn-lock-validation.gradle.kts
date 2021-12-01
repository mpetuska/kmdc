import org.gradle.api.tasks.Exec
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension
import java.io.File

// Make sure that all Gradle tasks use the same set of npm dependencies
// Reference: https://blog.jetbrains.com/kotlin/2021/10/control-over-npm-dependencies-in-kotlin-js/
rootProject.plugins.withType<YarnPlugin> {
  rootProject.extensions.configure<YarnRootExtension> { disableGranularWorkspaces() }
}

val yarnExecutablePath: String =
  with(rootProject.extensions.getByType<YarnRootExtension>()) {
    "$installationDir/yarn-v$version/bin/yarn"
  }

tasks {
  val yarnLockName = "yarn.lock"
  val yarnLockPrimaryName = "$yarnLockName.primary"
  val yarnBuildDirectory = "$rootDir/build/js"
  val yarnLockBuildPath = "$yarnBuildDirectory/$yarnLockName"
  val yarnLockPrimaryPath = "$rootDir/$yarnLockPrimaryName"

  @Suppress("UNUSED_VARIABLE")
  val yarnShowAuditReport by
  creating(Exec::class) {
    group = "nodejs"
    description = "Shows an audit report for npm packages, listing known vulnerabilities."
    workingDir = File(yarnBuildDirectory)
    commandLine = mutableListOf(yarnExecutablePath, "audit")
  }

  @Suppress("UNUSED_VARIABLE")
  val yarnShowOutdatedPackages by
  creating(Exec::class) {
    group = "nodejs"
    description = "Shows outdated npm packages."
    workingDir = File(yarnBuildDirectory)
    commandLine = mutableListOf(yarnExecutablePath, "outdated")
    isIgnoreExitValue = true
  }

  // Persist and validate yarn.lock, cf. https://youtrack.jetbrains.com/issue/KT-34014

  @Suppress("UNUSED_VARIABLE")
  val yarnLockUpdatePrimary by creating {
    group = "nodejs"
    description =
      "Updates '$yarnLockPrimaryName' from the build-generated '$yarnLockName'. Must be invoked manually."

    doLast {
      copy {
        from(yarnLockBuildPath)
        rename { yarnLockPrimaryName }
        into(rootDir)
      }
    }

    inputs.file(yarnLockBuildPath).withPropertyName("inputFile")
    outputs.file(yarnLockPrimaryPath).withPropertyName("outputFile")
  }

  @Suppress("UNUSED_VARIABLE")
  val yarnLockRestore by creating {
    group = "nodejs"
    description = "Restores '$yarnLockName' from '$yarnLockPrimaryName' to ensure stable builds."

    doLast {
      copy {
        from(yarnLockPrimaryPath)
        rename { yarnLockName }
        into("$rootDir/build/js")
      }
    }

    inputs.file(yarnLockPrimaryPath).withPropertyName("inputFile")
    outputs.file(yarnLockBuildPath).withPropertyName("outputFile")
  }

  val kotlinNpmInstall by
  getting(org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask::class) {
    dependsOn(yarnLockRestore)

    // Avoid package installation scripts vulnerability:
    // https://blog.npmjs.org/post/141702881055/package-install-scripts-vulnerability
    args += "--ignore-scripts"
    // To detect packages, which use installation scripts, see 'can-i-ignore-scripts', described
    // here:
    // https://dev.to/naugtur/get-safe-and-remain-productive-with-can-i-ignore-scripts-2ddc
  }

  val yarnLockValidate by creating {
    group = "nodejs"
    description =
      "Validates that the build directory's '$yarnLockName' corresponds to '$yarnLockPrimaryName' in the project root directory."
    // WORKAROUND kotlinNpmInstall failing:
    // https://youtrack.jetbrains.com/issue/KT-47215#focus=Comments-27-5308657.0-0
    val kotlinNpmCachesSetup by getting
    dependsOn(kotlinNpmCachesSetup, kotlinNpmInstall)

    doLast {
      val expected = File(yarnLockPrimaryPath).readText().trim()
      val actual = File(yarnLockBuildPath).readText().trim()

      if (expected != actual) {
        // WORKAROUND https://youtrack.jetbrains.com/issue/IDEA-267343 –
        //     'idea diff ...' produces an exception and does not immediately complete, although it
        // does
        //     open the diff window.
        //     Replace the following workaround with the code in comments when the issue is fixed.
        ProcessBuilder("idea", "diff", yarnLockPrimaryPath, yarnLockBuildPath)
          .redirectOutput(ProcessBuilder.Redirect.INHERIT)
          .redirectError(ProcessBuilder.Redirect.DISCARD)
          .start()
        /* Replace with:
        exec {
            commandLine = mutableListOf("idea", "diff", yarnLockPrimaryPath, yarnLockBuildPath)
        }
        */

        throw AssertionError(
          "The build-generated '${yarnLockName}' differs from '$yarnLockPrimaryName' in the project root directory." +
              " Each difference indicates a dependency update which has not been confirmed by" +
              " running './gradlew :yarnLockUpdatePrimary'.\n" +
              "\tAn idea diff window has been opened.\n" +
              "\tTo explore differences later, please run: idea diff '$yarnLockPrimaryPath' '$yarnLockBuildPath'")
      }
    }
  }

  kotlinNpmInstall.finalizedBy(yarnLockValidate)

  @Suppress("UNUSED_VARIABLE") val check by getting { dependsOn(yarnLockValidate) }
}
