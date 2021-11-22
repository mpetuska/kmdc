package local.test

import kotlinx.cinterop.toKStringFromUtf8
import platform.posix.getenv

actual object Environment {
  actual operator fun get(key: String): String? = getenv(key)?.toKStringFromUtf8()
}
