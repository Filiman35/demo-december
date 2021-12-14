package december.christmas.demo.repository;

import december.christmas.demo.dao.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomEmployeeRepository {
  Long getEmployeeBicycleId();

//  @Query("ssdfsdfs  :sfsdf")
//  List<Employee> findSomething(String id);
}
