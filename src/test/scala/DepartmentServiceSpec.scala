import crud.models.Department
import crud.repository.{DepartmentRepository}
import crud.services.{DepartmentService}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.MockitoSugar

class DepartmentServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  // Mocked EmployeeRepository
  val mockDepartmentRepository: DepartmentRepository = mock[DepartmentRepository]

  // Instantiate EmployeeService with the mocked repository
  val departmentService: DepartmentService = new DepartmentService(mockDepartmentRepository)

  "Department service" should "add an department" in {
    val newDepartment = Department(1,"BigData")
    when(mockDepartmentRepository.addDepartment(newDepartment)).thenReturn(List(newDepartment))
    val result = departmentService.addDepartment(newDepartment)
    result shouldEqual List(newDepartment)
  }

  it should "get an department by ID" in {
    val deptId = 1
    val expectedDepartment = Some(Department(deptId, "Bigdata"))
    when(mockDepartmentRepository.getDepartmentById(deptId)).thenReturn(expectedDepartment)
    val result = departmentService.getDepartmentById(deptId)
    result shouldEqual expectedDepartment
  }

  it should "update department" in {
    val departmentToUpdate = Department(1, "Devops")
    when(mockDepartmentRepository.updateDepartment(1,departmentToUpdate)).thenReturn(List(departmentToUpdate))
    val result = departmentService.updateDepartment(1,departmentToUpdate)
    result shouldEqual List(departmentToUpdate)
  }

  it should "get all departments list" in {
    val departments: List[Department] = List(
      Department(1, "Finance"),
      Department(2, "ERandD"))
    when(mockDepartmentRepository.getAllDepartments()).thenReturn(departments)
    val result = departmentService.getAllDepartments()
    result shouldEqual departments
  }


  it should "delete an department by ID" in {
    val departments: List[Department] = List(
      Department(1, "Finance"),
      Department(2, "ERandD"))

    when(mockDepartmentRepository.deleteDepartment(id = 1)).thenReturn(List(Department(2, "ERandD")))
    val result = departmentService.deleteDepartment(1)
    result shouldBe (List(Department(2, "ERandD")))
  }





}

