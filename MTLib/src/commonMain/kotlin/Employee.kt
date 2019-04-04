package jp.moneytree

/**
 * @author So Nakamura on 2019-Apr-04
 */
data class Employee(
  val name: String,
  val office: String
)

class EmployeeLoader {
  companion object {
    fun loadEmployees(): List<Employee> =
      listOf(
        Employee("Rendy", "Sydney"),
        Employee("Mitchell", "Sydney"),
        Employee("Jacky", "Sydney"),
        Employee("Anthony", "Tokyo"),
        Employee("Bhupe", "Tokyo")
      )
  }
}
