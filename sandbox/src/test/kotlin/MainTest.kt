package local.sandbox

import local.test.runBlockingTest
import kotlinx.coroutines.delay
import org.junit.Test

class MainTest {
  @Test
  fun test() = runBlockingTest {
    println(main())
    delay(500)
    println("After Delay: ${suspendingMain()}")
  }
}
