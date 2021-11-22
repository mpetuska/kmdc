package local.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.promise
import kotlin.coroutines.EmptyCoroutineContext

actual typealias CoroutineScope = CoroutineScope

actual fun runBlockingTest(test: suspend CoroutineScope.() -> Unit): dynamic =
  CoroutineScope(EmptyCoroutineContext).promise(block = test)
