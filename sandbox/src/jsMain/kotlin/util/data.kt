package sandbox.util

import kotlin.random.Random

fun randomImageUrl(
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
