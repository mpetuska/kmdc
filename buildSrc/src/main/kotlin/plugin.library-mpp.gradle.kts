import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinNativeCompile
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.konan.target.HostManager
import util.KotlinTargetDetails
import util.buildHost
import util.nativeTargetGroup

plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("plugin.common")
  id("dev.petuska.klip")
  id("com.android.library")
}

android {
  compileSdkVersion(31)
  defaultConfig {
    minSdkVersion(1)
    targetSdkVersion(31)
  }
}

kotlin {
  sourceSets {
    val commonMain by getting
    val commonTest by getting { dependencies { implementation(project(":test")) } }
    create("nativeMain") { dependsOn(commonMain) }
    create("nativeTest") { dependsOn(commonTest) }
  }

  explicitApi()
  android()
  jvm()
  js {
    binaries.library()
    useCommonJs()
    nodejs()
    //          browser {
    //            commonWebpackConfig {
    //              cssSupport.enabled = true
    //            }
    //            testTask {
    //              useKarma {
    //                useFirefox()
    //                useChrome()
    //                useSafari()
    //              }
    //            }
    //          }
  }

  nativeTargetGroup(
      "androidNdk",
      androidNativeArm32(),
      androidNativeArm64(),
  )

  nativeTargetGroup(
      "linux",
      linuxX64(),
      linuxMips32(),
      linuxMipsel32(),
      linuxArm64(),
      linuxArm32Hfp(),
  )

  nativeTargetGroup(
      "ios",
      iosArm32(),
      iosArm64(),
      iosX64(),
      iosSimulatorArm64(),
  )

  nativeTargetGroup(
      "watchos",
      watchosArm32(),
      watchosArm64(),
      watchosX86(),
      watchosX64(),
      watchosSimulatorArm64(),
  )

  nativeTargetGroup(
      "tvos",
      tvosArm64(),
      tvosX64(),
      tvosSimulatorArm64(),
  )

  nativeTargetGroup(
      "macos",
      macosX64(),
      macosArm64(),
  )

  nativeTargetGroup(
      "mingw",
      mingwX86(),
      mingwX64(),
  )

  val targetsWithCoroutines =
      KotlinTargetDetails.values()
          .filter(KotlinTargetDetails::hasCoroutines)
          .map(KotlinTargetDetails::presetName)

  targets.filter { it.preset?.name in targetsWithCoroutines }.forEach {
    (it.compilations.findByName("main")?.defaultSourceSet
            ?: sourceSets.findByName("${it.name}Main"))?.apply {
      dependencies { api("org.jetbrains.kotlinx:kotlinx-coroutines-core:_") }
    }
  }
}

tasks {
  project.properties["org.gradle.project.targetCompatibility"]?.toString()?.let {
    withType<KotlinCompile> { kotlinOptions { jvmTarget = it } }
  }
  withType<CInteropProcess> { onlyIf { konanTarget.buildHost == HostManager.host.family } }
  withType<AbstractKotlinNativeCompile<*, *>> {
    onlyIf { compilation.konanTarget.buildHost == HostManager.host.family }
  }
}
