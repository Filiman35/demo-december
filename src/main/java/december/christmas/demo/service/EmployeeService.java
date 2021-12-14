package december.christmas.demo.service;

import december.christmas.demo.dao.Employee;
import december.christmas.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

//  private final EmployeeRepository employeeRepository;
//
//  @Transactional(readOnly = true)
//  public void getEmployeeByFirstNameAndLastName() {
//    Optional<Employee> employeesOptional = employeeRepository.findByFirstNameAndLastName("Anatola", "Fattorini");
//  }
}
