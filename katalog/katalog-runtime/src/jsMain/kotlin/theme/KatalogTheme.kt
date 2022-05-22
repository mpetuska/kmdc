package dev.petuska.katalog.runtime.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

public data class KatalogTheme(
  public val highlightColor: CSSColorValue = Color("#F2BB05"),
  public val fontFamily: List<String> = listOf("Roboto", "sans-serif"),

  public val katalogTitleRender: @Composable (title: String) -> Unit = { H3 { Text(it) } },
  public val katalogSubtitleRender: @Composable (title: String) -> Unit = { H4 { Text(it) } },
  public val navTitleRender: @Composable (title: String) -> Unit = { H4 { Text(it) } },
  public val showcaseTitleRender: @Composable (title: String) -> Unit = { H3 { Text(it) } },
  public val showcaseDescriptionRender: @Composable (title: String) -> Unit = { P { Text(it) } },
)
