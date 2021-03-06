package ext

import org.gradle.api.*
import org.gradle.api.provider.*

@Suppress("LeakingThis")
abstract class KmdcExtension(project: Project) : NpmWrapperExtension(project) {
  abstract val mdc: Property<String>

  init {
    module.convention(mdc.map { "@material/$it" })
    versionKey.set("version.npm.material-components-web")
  }
}
