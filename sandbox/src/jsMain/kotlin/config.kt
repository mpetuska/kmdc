package sandbox

import dev.petuska.katalog.runtime.Katalog
import dev.petuska.katalog.runtime.KatalogConfig

//fun main() {
//  renderComposable(rootElementId = "root") {
//    samples.require("./sandbox.scss")
//    Sandbox()
//  }
//}

@KatalogConfig
fun Katalog.Builder.config() {
  samples.require("./sandbox.scss")
  title = "KMDC Katalog"
  subtitle = "Play around with various KMDC components"
  contentRootUrl = "https://github.com/mpetuska/kmdc/blob/master"
}
