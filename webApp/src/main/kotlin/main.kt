package jp.moneytree

import org.w3c.dom.events.Event
import kotlin.browser.document

/**
 * @author So Nakamura on 2019-Apr-04
 */
fun main() {
  //nothing here, it's executed before DOM is ready
  println("main() web called") //this is written to JavaScript browser's developer console
  document.addEventListener("DOMContentLoaded", {
    println("DOMContentLoaded")
    document.getElementById("startButton")?.addEventListener("click", ::start)
  })
}

fun start(ev: Event) {
  println("$ev")
  EmployeeLoader.loadEmployees().forEach {
    println("${it.name} - ${it.office}")
  }
}
