package local.test

actual object Environment {
  actual operator fun get(key: String): String? = System.getenv(key)
}
