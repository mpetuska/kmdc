@file:Suppress("PackageDirectoryMismatch")

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.*
import org.gradle.api.provider.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

val NamedDomainObjectContainer<KotlinSourceSet>.jsMain: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsMain")

val NamedDomainObjectContainer<KotlinSourceSet>.jsTest: NamedDomainObjectProvider<KotlinSourceSet>
  get() = named<KotlinSourceSet>("jsTest")

val Project.mdcVersion: String get() = libs.versions.npm.mdc.get()

fun KotlinDependencyHandler.kmdc(module: String) = project(":kmdc:kmdc-$module")
fun KotlinDependencyHandler.kmdcx(module: String) = project(":kmdcx:kmdcx-$module")

infix fun <T> Property<T>.by(value: T) = set(value)
infix fun <T> Property<T>.by(value: Provider<T>) = set(value)

internal val Project.libs get() = the<LibrariesForLibs>()
