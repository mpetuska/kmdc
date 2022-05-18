package dev.petuska.katalog.runtime

import dev.petuska.katalog.runtime.domain.Showcase

public data class Katalog internal constructor(
  val id: String,
  val title: String,
  val subtitle: String?,
  val contentRootUrl: String?,
  val showcases: List<Showcase>,
) {
  public class Builder(
    public var id: String = "katalog",
    public var title: String = "Katalog",
    public var subtitle: String? = null,
    public var contentRootUrl: String? = null,
    public var showcases: MutableList<Showcase>,
  ) {
    public fun build(): Katalog = Katalog(
      id = id,
      title = title,
      subtitle = subtitle,
      contentRootUrl = contentRootUrl,
      showcases = showcases,
    )
  }
}
