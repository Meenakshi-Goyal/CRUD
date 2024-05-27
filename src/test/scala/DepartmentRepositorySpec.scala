import crud.models.Department
import crud.repository.DepartmentRepository
import org.mockito.MockitoSugar
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class DepartmentRepositorySpec extends AnyWordSpec with Matchers with MockitoSugar {

  "DepartmentRepository" should {

    "return all departments" in {
      val departmentRepository = new DepartmentRepositoryImpl

      val allDepartments = departmentRepository.getAllDepartments()

      allDepartments shouldBe List(
        Department(11, "Finance"),
        Department(12, "IT"),
        Department(13, "QA"),
        Department(14, "ERnD")
      )
    }

    "return a department by id" in {
      val departmentRepository = new DepartmentRepositoryImpl

      val departmentById = departmentRepository.getDepartmentById(12)

      departmentById shouldBe Some(Department(12, "IT"))
    }

    "add a new department" in {
      val departmentRepository = new DepartmentRepositoryImpl

      val newDepartment = Department(15, "Marketing")
      val updatedDepartments = departmentRepository.addDepartment(newDepartment)

      updatedDepartments shouldBe List(
        Department(11, "Finance"),
        Department(12, "IT"),
        Department(13, "QA"),
        Department(14, "ERnD"),
        newDepartment
      )
    }

    "update a department by id" in {
      val departmentRepository = new DepartmentRepositoryImpl

      val updatedDepartment = Department(12, "New IT Department")
      val updatedDepartments = departmentRepository.updateDepartment(12, updatedDepartment)

      updatedDepartments shouldBe List(
        Department(11, "Finance"),
        updatedDepartment,
        Department(13, "QA"),
        Department(14, "ERnD")
      )
    }

    "delete a department by id" in {
      val departmentRepository = new DepartmentRepositoryImpl

      val deletedDepartmentId = 13
      val updatedDepartments = departmentRepository.deleteDepartment(deletedDepartmentId)

      updatedDepartments shouldBe List(
        Department(11, "Finance"),
        Department(12, "IT"),
        Department(14, "ERnD")
      )
    }
  }

  // Mock implementation of DepartmentRepository for testing
  class DepartmentRepositoryImpl extends DepartmentRepository {
    override def getAllDepartments(): List[Department] = List(
      Department(11, "Finance"),
      Department(12, "IT"),
      Department(13, "QA"),
      Department(14, "ERnD")
    )

    override def getDepartmentById(id: Int): Option[Department] = getAllDepartments().find(_.id == id)

    override def addDepartment(department: Department): List[Department] = getAllDepartments() :+ department

    override def updateDepartment(id: Int, department: Department): List[Department] = {
      getAllDepartments().map {
        case d if d.id == id => department
        case d => d
      }
    }

    override def deleteDepartment(id: Int): List[Department] = getAllDepartments().filterNot(_.id == id)
  }
}
