package dev.petuska.katalog.plugin

import com.google.devtools.ksp.processing.*
import java.io.*

public class KatalogSymbolProcessorProvider : SymbolProcessorProvider {
  override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
    require(environment.platforms.size == 1 && environment.platforms.any { it is JsPlatformInfo })
    return KatalogSymbolProcessor(
      codeGenerator = environment.codeGenerator,
      logger = environment.logger,
      contentRoot = environment.options["katalog.contentRoot"]?.let(::File),
    )
  }
}
