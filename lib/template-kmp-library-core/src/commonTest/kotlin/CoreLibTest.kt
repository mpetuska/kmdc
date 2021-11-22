package dev.petuska.template.kmp.library.core

import dev.petuska.klip.api.assertKlip
import local.test.BlockingTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CoreLibTest : BlockingTest {
  @Test
  fun test() = blockingTest {
    val result = CoreLib().sampleApi()
    println(result)
    assertEquals(result, platform)
  }

  @Test
  fun testSuspend() = blockingTest {
    val result = CoreLib().sampleSuspendApi()
    println(result)
    assertEquals(result, platform)
  }

  @Test
  fun testValue() = blockingTest {
    val result = CoreLib().sampleValue
    println(result)
    result.assertKlip()
  }
}
