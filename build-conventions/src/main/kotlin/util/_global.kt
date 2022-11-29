@file:Suppress("PackageDirectoryMismatch")

import de.fayard.refreshVersions.core.*
import org.gradle.api.*
import org.gradle.api.provider.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

val NamedDomainObjectContainer<KotlinSourceSet>.jsMain: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsMain")

val NamedDomainObjectContainer<KotlinSourceSet>.jsTest: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsTest")

val Project.mdcVersion: String get() = versionFor("version.npm.material-components-web")

fun KotlinDependencyHandler.kmdc(module: String) = project(":kmdc:kmdc-$module")
fun KotlinDependencyHandler.kmdcx(module: String) = project(":kmdcx:kmdcx-$module")

infix fun <T> Property<T>.by(value: T) = set(value)
infix fun <T> Property<T>.by(value: Provider<T>) = set(value)
