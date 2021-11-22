package dev.petuska.template.kmp.library.core

internal expect val platform: String

public class CoreLib {
  public fun sampleApi(): String = platform
  public suspend fun sampleSuspendApi(): String = sampleApi()
  public val sampleValue: Number = 420 * 69
}
