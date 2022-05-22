package ext

import org.gradle.api.*
import org.gradle.api.provider.*
import org.gradle.api.tasks.*

@Suppress("LeakingThis")
abstract class PomExtension(private val project: Project) {
  @get:Nested
  internal abstract val owner: Owner
  internal abstract val name: Property<String>
  internal abstract val description: Property<String>
  internal abstract val version: Property<String>

  init {
    name.convention(project.name)
    description.convention(project.provider { project.description })
    version.convention(project.provider { project.version.toString() })
  }

  abstract class Owner {
    internal abstract val id: Property<String>
    internal abstract val repo: Property<String>
    internal abstract val name: Property<String>
    internal abstract val email: Property<String>

    init {
      id.convention("mpetuska")
      repo.convention("kmdc")
      name.convention("Martynas Petuška")
      email.convention("martynas@petuska.dev")
    }
  }
}
