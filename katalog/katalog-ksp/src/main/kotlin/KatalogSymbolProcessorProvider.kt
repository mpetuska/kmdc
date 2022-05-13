package dev.petuska.katalog.plugin

import com.google.devtools.ksp.processing.JsPlatformInfo
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class KatalogSymbolProcessorProvider : SymbolProcessorProvider {
  override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
    require(environment.platforms.size == 1 && environment.platforms.any { it is JsPlatformInfo })
    return KatalogSymbolProcessor(
      environment.codeGenerator,
      environment.logger,
    )
  }
}
