package jp.moneytree

import kotlin.test.Test
import kotlin.test.assertEquals

open class Test {
  @Test
  fun testFactory() {
    val product = Factory.create(mapOf("user" to "jetbrains"))
    assertEquals(product.user, "jetbrains")
  }
}
