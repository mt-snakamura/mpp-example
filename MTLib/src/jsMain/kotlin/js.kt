package jp.moneytree

/**
 * @author So Nakamura on 2019-Apr-04
 */
actual class Platform actual constructor() {
  actual val platform: String = "js"
}

actual class Product(actual val user: String) {
  val model: String = ""

  fun iosSpecificOperation() {
    println("I am $model")
  }

  override fun toString() = "js product of $user for $model"
}

actual object Factory {
  actual fun create(config: Map<String, String>) =
    Product(config["user"]!!)

  actual val platform: String = "js"
}
