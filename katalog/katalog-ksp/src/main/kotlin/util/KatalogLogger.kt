package dev.petuska.katalog.plugin.util

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*

interface KatalogLogger {
  val logger: KSPLogger
  fun error(message: String, symbol: KSNode? = null): Nothing {
    logger.error(message.prefix(), symbol)
    throw IllegalStateException()
  }

  fun warn(message: String, symbol: KSNode? = null) = logger.warn(message.prefix(), symbol)
  fun info(message: String, symbol: KSNode? = null) = logger.info(message.prefix(), symbol)
  fun debug(message: String, symbol: KSNode? = null) = logger.logging(message.prefix(), symbol)

  companion object {
    private fun String.prefix() = "[katalog] $this"
  }
}
