package local.test

import kotlinx.coroutines.runBlocking

actual typealias CoroutineScope = kotlinx.coroutines.CoroutineScope

actual fun runBlockingTest(test: suspend CoroutineScope.() -> Unit): Unit =
  runBlocking(block = test)
