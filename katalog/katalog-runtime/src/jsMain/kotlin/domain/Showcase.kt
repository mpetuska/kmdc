package dev.petuska.katalog.runtime.domain

import androidx.compose.runtime.Composable

public typealias ShowcaseContent = @Composable () -> Unit

public data class Showcase(
  val id: String,
  val title: String,
  val description: String?,
  val location: String?,
  val content: ShowcaseContent
)
