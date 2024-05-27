package crud.repository

import crud.models.Employee

//Employee repository trait
trait EmployeeRepository {
  def getAllEmployees(): List[Employee]
  def getEmployeeById(id: Int): Option[Employee]
  def addEmployee(employee: Employee): List[Employee]
  def updateEmployee(id:Int , employee: Employee): List[Employee]
  def deleteEmployee(id: Int): List[Employee]

  }

