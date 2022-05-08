import de.fayard.refreshVersions.core.versionFor
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

val org.gradle.api.NamedDomainObjectContainer<KotlinSourceSet>.jsMain: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsMain")

val org.gradle.api.NamedDomainObjectContainer<KotlinSourceSet>.jsTest: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsTest")

val mdcVersion = versionFor("version.npm.material-components-web")

fun KotlinDependencyHandler.kmdc(module: String) = project(":kmdc:kmdc-$module")
fun KotlinDependencyHandler.mdc(module: String) = npm("@material/$module", mdcVersion)
