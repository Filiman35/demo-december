package december.christmas.demo.repository;

import december.christmas.demo.dao.ChristmasPresent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ChristmasPresentRepository extends JpaRepository<ChristmasPresent, Long> {
  ChristmasPresent findByDescription(String description);

  ChristmasPresent getById(Long presentId);

  List<ChristmasPresent> findAll(Sort sort);
}