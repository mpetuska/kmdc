package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSNode

public interface KatalogLogger {
  public val logger: KSPLogger
  public fun error(message: String, symbol: KSNode? = null): Nothing {
    logger.error(message.prefix(), symbol)
    kotlin.error("error log")
  }

  public fun warn(message: String, symbol: KSNode? = null): Unit = logger.warn(message.prefix(), symbol)
  public fun info(message: String, symbol: KSNode? = null): Unit = logger.info(message.prefix(), symbol)
  public fun debug(message: String, symbol: KSNode? = null): Unit = logger.logging(message.prefix(), symbol)

  public companion object {
    private fun String.prefix() = "[katalog] $this"
  }
}
