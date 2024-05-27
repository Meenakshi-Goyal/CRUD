package crud.services

import crud.models.Department
import crud.repository.DepartmentRepository

// Department service with constructor injection
class DepartmentService(departmentRepository: DepartmentRepository) {
  def getAllDepartments(): List[Department] = departmentRepository.getAllDepartments()
  def getDepartmentById(id: Int): Option[Department] = departmentRepository.getDepartmentById(id)
  def addDepartment(department: Department): List[Department] = departmentRepository.addDepartment(department)
  def updateDepartment(id:Int , department:Department): List[Department] = departmentRepository.updateDepartment(id , department)
  def deleteDepartment(id: Int): List[Department] = departmentRepository.deleteDepartment(id)
}

