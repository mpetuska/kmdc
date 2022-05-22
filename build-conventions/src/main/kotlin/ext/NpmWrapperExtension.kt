package ext

import de.fayard.refreshVersions.core.*
import jsMain
import org.gradle.api.*
import org.gradle.api.plugins.*
import org.gradle.api.provider.*
import org.jetbrains.compose.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

@Suppress("LeakingThis")
abstract class NpmWrapperExtension(private val project: Project) {
  abstract val module: Property<String>
  abstract val version: Property<String>
  abstract val versionKey: Property<String>

  init {
    version.convention(versionKey.map(::versionFor))
  }

  fun dependencies(action: Action<Dependencies>) {
    action.execute(
      Dependencies(
        project.extensions.getByType(KotlinMultiplatformExtension::class.java)
      )
    )
  }


  class Dependencies(private val kotlin: KotlinMultiplatformExtension) {
    val compose: ComposePlugin.Dependencies =
      (kotlin as ExtensionAware).extensions.getByType(ComposePlugin.Dependencies::class.java)

    fun main(action: KotlinDependencyHandler.() -> Unit) {
      kotlin.sourceSets.jsMain.configure {
        dependencies(action)
      }
    }

    fun test(action: KotlinDependencyHandler.() -> Unit) {
      kotlin.sourceSets.jsMain.configure {
        dependencies(action)
      }
    }
  }
}
