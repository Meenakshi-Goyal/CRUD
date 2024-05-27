package crud.main

import crud.impl.{DepartmentImpl, EmployeeImpl}
import crud.models.Employee
import crud.repository.{DepartmentRepository, EmployeeRepository}
import crud.services.{DepartmentService, EmployeeServices}

object Main extends App {

  val employeeRepository: EmployeeRepository = new EmployeeImpl
  val departmentRepository: DepartmentRepository = new DepartmentImpl

  // Instantiate services with injected repositories
  val employeeService: EmployeeServices = new EmployeeServices(employeeRepository)
  val departmentService: DepartmentService = new DepartmentService(departmentRepository)

  // Use the services
  val allEmployees = employeeService.getAllEmployees()
  println(s"\n All employees: $allEmployees")

  val newEmployee = employeeService.addEmployee(Employee(6, "NewEmloyee", 14))
  println(s"\n Added employee: $newEmployee")

  val updatedEmployee = employeeService.updateEmployee(id = 2 , Employee(2, "Yash", 11))
  println(s"\n Updated employee: $updatedEmployee")

  val deleted = employeeService.deleteEmployee(id = 6)
  println(s"\n Employee deleted: $deleted")

  val allDepartments = departmentService.getAllDepartments()
  println(s"\n All departments: $allDepartments")

  val getDepartById = departmentService.getDepartmentById(id = 11)
  println(s"\n Department for this id is: $getDepartById")


}