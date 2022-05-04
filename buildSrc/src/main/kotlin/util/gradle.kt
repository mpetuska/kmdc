package util

import groovy.lang.Closure
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.jetbrains.kotlin.konan.target.HostManager
import java.nio.charset.Charset

typealias Lambda<R, V> = R.() -> V

val CI by lazy { !"false".equals(System.getenv("CI") ?: "false", true) }
val SANDBOX by lazy { !"false".equals(System.getenv("SANDBOX") ?: "false", true) }

fun <R, V> Lambda<R, V>.toClosure(owner: Any? = null, thisObj: Any? = null) =
  object : Closure<V>(owner, thisObj) {
    @Suppress("UNCHECKED_CAST")
    fun doCall() {
      with(delegate as R) { this@toClosure() }
    }
  }

fun <R, V> closureOf(owner: Any? = null, thisObj: Any? = null, func: R.() -> V) =
  func.toClosure(owner, thisObj)

infix fun <T> Property<T>.by(value: T) {
  set(value)
}

object Git {
  val headCommitHash by lazy { execAndCapture("git rev-parse --verify HEAD") }
}

fun execAndCapture(cmd: String): String? {
  val child = Runtime.getRuntime().exec(cmd)
  child.waitFor()
  return if (child.exitValue() == 0) {
    child.inputStream.readAllBytes().toString(Charset.defaultCharset()).trim()
  } else null
}

val Project.isMainHost: Boolean
  get() = HostManager.simpleOsName().equals("${properties["project.mainOS"]}", true)
