package december.christmas.demo.repository.implementation;

import december.christmas.demo.dao.Employee;
import december.christmas.demo.repository.CustomEmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomEmployeeRepoImpl implements CustomEmployeeRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Long getEmployeeBicycleId() {
    return entityManager.createQuery("SELECT bicycle_id FROM employee WHERE id = 1",
        Long.class).getResultList().get(0);
  }
}
