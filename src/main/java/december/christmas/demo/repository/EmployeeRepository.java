package december.christmas.demo.repository;

import java.util.List;
import java.util.Optional;

import december.christmas.demo.dao.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  List<Employee> findByLastName(String lastName);

  Employee findById(long id);

  Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}