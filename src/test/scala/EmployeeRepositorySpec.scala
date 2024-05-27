import crud.models.Employee
import crud.repository.EmployeeRepository
import org.mockito.MockitoSugar
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers


class EmployeeRepositorySpec extends AnyWordSpec with Matchers with MockitoSugar {

  "EmployeeRepository" should {

    "return all employees" in {
      val employeeRepository = new EmployeeRepositoryImpl

      val allEmployees = employeeRepository.getAllEmployees()

      allEmployees shouldBe List(
        Employee(101, "John Doe", 11),
        Employee(102, "Jane Smith", 12),
        Employee(103, "Bob Johnson", 13),
        Employee(104, "Alice Brown", 14)
      )
    }

    "return an employee by id" in {
      val employeeRepository = new EmployeeRepositoryImpl

      val employeeById = employeeRepository.getEmployeeById(102)

      employeeById shouldBe Some(Employee(102, "Jane Smith", 12))
    }

    "add a new employee" in {
      val employeeRepository = new EmployeeRepositoryImpl

      val newEmployee = Employee(105, "Eva Green", 15)
      val updatedEmployees = employeeRepository.addEmployee(newEmployee)

      updatedEmployees shouldBe List(
        Employee(101, "John Doe", 11),
        Employee(102, "Jane Smith", 12),
        Employee(103, "Bob Johnson",13),
        Employee(104, "Alice Brown", 14),
        newEmployee
      )
    }

    "update an employee by id" in {
      val employeeRepository = new EmployeeRepositoryImpl

      val updatedEmployee = Employee(103, "New Bob Johnson", 13)
      val updatedEmployees = employeeRepository.updateEmployee(103, updatedEmployee)

      updatedEmployees shouldBe List(
        Employee(101, "John Doe", 11),
        Employee(102, "Jane Smith", 12),
        updatedEmployee,
        Employee(104, "Alice Brown", 14)
      )
    }

    "delete an employee by id" in {
      val employeeRepository = new EmployeeRepositoryImpl

      val deletedEmployeeId = 102
      val updatedEmployees = employeeRepository.deleteEmployee(deletedEmployeeId)

      updatedEmployees shouldBe List(
        Employee(101, "John Doe", 11),
        Employee(103, "Bob Johnson", 13),
        Employee(104, "Alice Brown", 14)
      )
    }
  }

  // Mock implementation of EmployeeRepository for testing
  class EmployeeRepositoryImpl extends EmployeeRepository {
    override def getAllEmployees(): List[Employee] = List(
      Employee(101, "John Doe", 11),
      Employee(102, "Jane Smith", 12),
      Employee(103, "Bob Johnson", 13),
      Employee(104, "Alice Brown", 14)
    )

    override def getEmployeeById(id: Int): Option[Employee] = getAllEmployees().find(_.id == id)

    override def addEmployee(employee: Employee): List[Employee] = getAllEmployees() :+ employee

    override def updateEmployee(id: Int, employee: Employee): List[Employee] = {
      getAllEmployees().map {
        case e if e.id == id => employee
        case e => e
      }
    }

    override def deleteEmployee(id: Int): List[Employee] = getAllEmployees().filterNot(_.id == id)

  }
}

