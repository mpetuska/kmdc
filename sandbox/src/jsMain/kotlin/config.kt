package sandbox

import dev.petuska.katalog.runtime.Katalog
import dev.petuska.katalog.runtime.KatalogConfig
import sandbox.util.requireModule

@KatalogConfig
fun Katalog.Builder.config() {
  requireModule("./sandbox.scss")
  title = "KMDC Katalog"
  subtitle = "Play around with various KMDC components"
  contentRootUrl = "https://github.com/mpetuska/kmdc/blob/master"
}
