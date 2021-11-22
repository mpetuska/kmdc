package local.test

expect interface CoroutineScope

internal expect fun runBlockingTest(test: suspend CoroutineScope.() -> Unit)

interface BlockingTest {
  suspend fun beforeEach() {}
  suspend fun afterEach() {}

  fun blockingTest(action: suspend CoroutineScope.() -> Unit) = runBlockingTest {
    try {
      beforeEach()
      action()
    } catch (e: Throwable) {
      afterEach()
      throw e
    }
    afterEach()
  }
}
