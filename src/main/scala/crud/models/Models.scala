package crud.models

// Employee model
case class Employee(id: Int, name: String, departmentId: Int)

// Department model
case class Department(id: Int, name: String)
