package util

import org.jetbrains.kotlin.konan.target.Family
import org.jetbrains.kotlin.konan.target.KonanTarget

enum class KotlinTargetDetails(
    val presetName: String,
    val hasCoroutines: Boolean,
) {
  JVM("jvm", true),
  ANDROID("android", true),
  JS("jsIr", true),
  ANDROID_NDK_ARM32("androidNativeArm32", false),
  ANDROID_NDK_ARM64("androidNativeArm64", false),
  IOS_ARM32("iosArm32", true),
  IOS_ARM64("iosArm64", true),
  IOS_X64("iosX64", true),
  IOS_SIMULATOR_ARM64("iosSimulatorArm64", true),
  WATCHOS_X86("watchosX86", true),
  WATCHOS_X64("watchosX64", true),
  WATCHOS_ARM64("watchosArm64", true),
  WATCHOS_ARM32("watchosArm32", true),
  WATCHOS_SIMULATOR_ARM64("watchosSimulatorArm64", true),
  TVOS_ARM64("tvosArm64", true),
  TVOS_X64("tvosX64", true),
  TVOS_SIMULATOR_ARM64("tvosSimulatorArm64", true),
  MACOS_X64("macosX64", true),
  MACOS_ARM64("macosArm64", true),
  LINUX_ARM32_HFP("linuxArm32Hfp", false),
  LINUX_MIPS32("linuxMips32", false),
  LINUX_MIPSEL32("linuxMipsel32", false),
  LINUX_X64("linuxX64", true),
  LINUX_ARM64("linuxArm64", false),
  MINGW_X64("mingwX64", true),
  MINGW_X32("mingwX86", false),
}

val KonanTarget.buildHost: Family
  get() =
      when (this) {
        KonanTarget.ANDROID_X64,
        KonanTarget.ANDROID_X86,
        KonanTarget.ANDROID_ARM32,
        KonanTarget.ANDROID_ARM64,
        KonanTarget.LINUX_ARM64,
        KonanTarget.LINUX_ARM32_HFP,
        KonanTarget.LINUX_MIPS32,
        KonanTarget.LINUX_MIPSEL32,
        KonanTarget.LINUX_X64 -> Family.LINUX
        KonanTarget.MINGW_X86, KonanTarget.MINGW_X64 -> Family.MINGW
        KonanTarget.IOS_ARM32,
        KonanTarget.IOS_ARM64,
        KonanTarget.IOS_X64,
        KonanTarget.IOS_SIMULATOR_ARM64,
        KonanTarget.WATCHOS_ARM32,
        KonanTarget.WATCHOS_ARM64,
        KonanTarget.WATCHOS_X86,
        KonanTarget.WATCHOS_X64,
        KonanTarget.WATCHOS_SIMULATOR_ARM64,
        KonanTarget.TVOS_ARM64,
        KonanTarget.TVOS_X64,
        KonanTarget.TVOS_SIMULATOR_ARM64,
        KonanTarget.MACOS_X64,
        KonanTarget.MACOS_ARM64 -> Family.OSX
        KonanTarget.WASM32 -> throw IllegalStateException("Target $this not supported")
        is KonanTarget.ZEPHYR -> throw IllegalStateException("Target $this not supported")
      }
