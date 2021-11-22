package local.test

actual interface CoroutineScope

actual fun runBlockingTest(test: suspend CoroutineScope.() -> Unit): Unit =
  println("Coroutines not supported on linuxArm64")
