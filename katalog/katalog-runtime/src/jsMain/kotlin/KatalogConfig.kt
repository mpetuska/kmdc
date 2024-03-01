package dev.petuska.katalog.runtime

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
public annotation class KatalogConfig(
  val priority: Int = 0
)
