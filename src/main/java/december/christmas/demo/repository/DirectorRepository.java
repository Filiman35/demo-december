package december.christmas.demo.repository;

import december.christmas.demo.dao.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DirectorRepository extends PagingAndSortingRepository<Employee, String> {

  Page<Employee> findAll(Pageable pageable);

  List<Employee> findAll(Sort sort);
}
