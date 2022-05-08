package dev.petuska.kmdc.core

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class CounterTest {
  @Test
  fun keyNeverChanges() {
    kmdcCounterKey shouldBe "_kmdcCounter"
  }
}
