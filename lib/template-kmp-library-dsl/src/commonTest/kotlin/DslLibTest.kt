package dev.petuska.template.kmp.library.dsl

import local.test.BlockingTest
import kotlin.test.Test
import kotlin.test.assertTrue

class DslLibTest : BlockingTest {
  override suspend fun beforeEach() {
    println("Starting")
  }

  override suspend fun afterEach() {
    println("Completed")
  }

  @Test
  fun test() = blockingTest {
    val result = "sync".withPlatform()
    println(result)
    assertTrue(result.contains(platform))
  }

  @Test
  fun testSuspend() = blockingTest {
    val result = "async".withPlatformSuspend()
    println(result)
    assertTrue(result.contains(platform))
  }
}
