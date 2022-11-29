package dev.petuska.katalog.runtime.theme

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

public data class KatalogTheme(
  public val highlightColor: CSSColorValue = Color("#F2BB05"),
  public val fontFamily: List<String> = listOf("Roboto", "sans-serif"),

  public val katalogTitleRender: @Composable (title: String) -> Unit = { H3 { Text(it) } },
  public val katalogSubtitleRender: @Composable (title: String) -> Unit = { H4 { Text(it) } },
  public val navTitleRender: @Composable (title: String, selected: Boolean) -> Unit = { text, _ -> H4 { Text(text) } },
  public val showcaseTitleRender: @Composable (title: String) -> Unit = { H3 { Text(it) } },
  public val showcaseDescriptionRender: @Composable (title: String) -> Unit = { P { Text(it) } },
)
