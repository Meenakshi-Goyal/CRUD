package crud.impl
import crud.main.Main.departmentService.getDepartmentById
import crud.models.{Department, Employee}
import crud.repository.{DepartmentRepository, EmployeeRepository}

class EmployeeImpl extends EmployeeRepository {
  private val initialEmployees: List[Employee] = List(
    Employee(1, "Leela", 11),
    Employee(2, "Arya", 12),
    Employee(3, "Rohan",13),
    Employee(4, "Shruti", 11),
    Employee(5, "Nagarjuna", 14)
  )

  private var employees: List[Employee] = initialEmployees

  def getAllEmployees(): List[Employee] = employees

  def getEmployeeById(id: Int): Option[Employee]= employees.find(_.id == id)

  def addEmployee(employee: Employee): List[Employee] = employees :+ employee

  def updateEmployee(id: Int, updatedEmployee: Employee): List[Employee] = {
    employees.map {
      case e if e.id == id => updatedEmployee
      case e => e
    }
  }

  def deleteEmployee(id: Int): List[Employee] = employees.filterNot(_.id == id)

}
