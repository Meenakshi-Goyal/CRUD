package crud.impl

import crud.models.Department
import crud.repository.DepartmentRepository

class DepartmentImpl extends DepartmentRepository {

  private val initialDepartments: List[Department] = List(
    Department(11,"Finance"),
    Department(12,"IT"),
    Department(13,"QA"),
    Department(14,"ERnD")
  )

  private var departments: List[Department] = initialDepartments

  def getAllDepartments(): List[Department] = departments

  def getDepartmentById(id: Int): Option[Department] = departments.find(_.id == id)

  def addDepartment(department: Department): List[Department] =  departments :+ department

  def updateDepartment(id: Int, updatedDepartment: Department): List[Department] = {
    departments.map {
      case d if d.id == id => updatedDepartment
      case d => d
    }
  }

  def deleteDepartment(id: Int): List[Department] = departments.filterNot(_.id == id)
}
