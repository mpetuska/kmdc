package dev.petuska.katalog.runtime.util

import kotlin.random.Random

public val LoremIpsum: String = """
  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur
  pretium vitae est et dapibus. Aenean sit amet felis eu lorem fermentum
  aliquam sit amet sit amet eros.
""".trimIndent()

public const val RickRollUrl: String = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"

public fun randomImageUrl(
  seed: String = "kmdc",
  maxWidth: UInt = 300u,
  maxHeight: UInt = maxWidth,
  minWidth: UInt = 50u,
  minHeight: UInt = minWidth,
): String {
  val width: Int = Random.nextInt(maxWidth.toInt()) + minWidth.toInt()
  val height: Int = Random.nextInt(maxHeight.toInt()) + minHeight.toInt()
  return "https://picsum.photos/seed/$seed/$width/$height"
}
