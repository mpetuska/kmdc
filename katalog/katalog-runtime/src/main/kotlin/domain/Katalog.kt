package dev.petuska.katalog.runtime.domain

import dev.petuska.katalog.runtime.theme.KatalogTheme

public data class Katalog internal constructor(
  val id: String,
  val title: String,
  val subtitle: String?,
  val contentRootUrl: String?,
  val debug: Boolean,
  val showcases: List<Showcase>,
  val theme: KatalogTheme,
) {
  @Suppress("LongParameterList")
  public class Builder(
    public var id: String = "katalog",
    public var title: String = "Katalog",
    public var subtitle: String? = null,
    public var contentRootUrl: String? = null,
    public var debug: Boolean = false,
    public var theme: KatalogTheme = KatalogTheme(),
    public var showcases: MutableList<Showcase>
  ) {
    public fun build(): Katalog = Katalog(
      id = id,
      title = title,
      subtitle = subtitle,
      contentRootUrl = contentRootUrl,
      debug = debug,
      theme = theme,
      showcases = showcases,
    )
  }
}
