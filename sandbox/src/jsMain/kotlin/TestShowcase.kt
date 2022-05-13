package test

import androidx.compose.runtime.Composable
import dev.petuska.katalog.runtime.KatalogConfig
import dev.petuska.katalog.runtime.Showcase
import org.jetbrains.compose.web.dom.Text

@Composable
@Showcase(title = "Title", description = "Description")
fun TestShowcase(title: String, description: String) {
  Text("Hello! $title, $description")
}

object Container {
  @Composable
  @Showcase(title = "Title", description = "Description", id = "my-showcase")
  fun TestShowcase2(title: String, description: String) {
    Text("Hello! $title, $description")
  }
}

@KatalogConfig
fun config() {
  samples.require("./sandbox.scss")
}
