package dev.petuska.kmdc.core

import io.kotest.matchers.*
import kotlin.test.*

class CounterTest {
  @Test
  fun keyNeverChanges() {
    kmdcCounterKey shouldBe "_kmdcCounter"
  }
}
