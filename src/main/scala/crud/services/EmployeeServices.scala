package crud.services

import crud.models.Employee
import crud.repository.EmployeeRepository

// Employee service with constructor injection
class EmployeeServices(employeeRepository: EmployeeRepository) {
  def getAllEmployees(): List[Employee] = employeeRepository.getAllEmployees()
  def getEmployeeById(id: Int): Option[Employee] = employeeRepository.getEmployeeById(id)
  def addEmployee(employee: Employee): List[Employee] = employeeRepository.addEmployee(employee)
  def updateEmployee(id:Int, employee: Employee): List[Employee] = employeeRepository.updateEmployee(id, employee)
  def deleteEmployee(id: Int): List[Employee] = employeeRepository.deleteEmployee(id)

}