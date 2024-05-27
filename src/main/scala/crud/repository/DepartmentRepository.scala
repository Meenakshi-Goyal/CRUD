package crud.repository

import crud.models.Department

// Department repository trait
trait DepartmentRepository {
  def getAllDepartments(): List[Department]
  def getDepartmentById(id: Int): Option[Department]
  def addDepartment(department: Department): List[Department]
  def updateDepartment(id:Int, department: Department): List[Department]
  def deleteDepartment(id: Int): List[Department]
}
