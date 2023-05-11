package ext

import libs
import org.gradle.api.*
import org.gradle.api.provider.*

@Suppress("LeakingThis")
abstract class KmdcExtension(project: Project) : NpmWrapperExtension {
  abstract val mdc: Property<String>

  init {
    module.convention(mdc.map { "@material/$it" })
    version.convention(project.libs.versions.npm.mdc)
  }
}
