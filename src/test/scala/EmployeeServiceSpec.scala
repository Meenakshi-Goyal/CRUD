import crud.models.Employee
import crud.repository.EmployeeRepository
import crud.services.EmployeeServices
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.MockitoSugar

class EmployeeServiceSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  // Mocked EmployeeRepository
  val mockEmployeeRepository: EmployeeRepository = mock[EmployeeRepository]

  // Instantiate EmployeeService with the mocked repository
  val employeeService: EmployeeServices = new EmployeeServices(mockEmployeeRepository)

  "EmployeeService" should "add an employee" in {
    val employeeToAdd = Employee(1, "John", 11)
    when(mockEmployeeRepository.addEmployee(employeeToAdd)).thenReturn(List(employeeToAdd))
    val result = employeeService.addEmployee(employeeToAdd)
    result shouldEqual List(employeeToAdd)
  }

  it should "get an employee by ID" in {
    val employeeId = 1
    val expectedEmployee = Some(Employee(employeeId, "John", 1))
    when(mockEmployeeRepository.getEmployeeById(employeeId)).thenReturn(expectedEmployee)
    val result = employeeService.getEmployeeById(employeeId)
    result shouldEqual expectedEmployee
  }

  it should "update an employee" in {
    val employeeToUpdate = Employee(1, "John Doe", 1)
    when(mockEmployeeRepository.updateEmployee(1,employeeToUpdate)).thenReturn(List(employeeToUpdate))
    val result = employeeService.updateEmployee(1,employeeToUpdate)
    result shouldEqual List(employeeToUpdate)
  }

  it should "get all employees list" in {
    val employees: List[Employee] = List(
      Employee(1, "Leela", 11),
      Employee(2, "Arya", 12))
    when(mockEmployeeRepository.getAllEmployees()).thenReturn(employees)
    val result = employeeService.getAllEmployees()
    result shouldEqual employees
  }


  it should "delete an employee by ID" in {
    val employees: List[Employee] = List(
      Employee(1, "Leela", 11),
      Employee(2, "Arya", 12))

    when(mockEmployeeRepository.deleteEmployee(id = 1)).thenReturn(List(Employee(2, "Arya", 12)))
    val result = employeeService.deleteEmployee(1)
    result shouldBe (List(Employee(2, "Arya", 12)))
  }
}

