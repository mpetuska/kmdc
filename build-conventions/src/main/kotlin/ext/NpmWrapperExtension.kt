package ext

import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.provider.Property

interface NpmWrapperExtension : ExtensionAware {
  val module: Property<String>
  val version: Property<String>
}
