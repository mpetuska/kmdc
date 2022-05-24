package dev.petuska.katalog.runtime

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
public annotation class Showcase(
  val id: String = "",
  val title: String = "",
  val description: String = "",
)
