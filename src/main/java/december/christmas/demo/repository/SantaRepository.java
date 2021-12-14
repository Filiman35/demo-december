package december.christmas.demo.repository;

import december.christmas.demo.dao.ChristmasPresent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SantaRepository extends CrudRepository<ChristmasPresent, Long> {

  long	count();

  void	delete(ChristmasPresent present);

  void	deleteAll();

  void	deleteAll(List<ChristmasPresent> presents);

  void	deleteAllById(Set<Long> presentIds);

  void	deleteById(Long presentId);

  boolean	existsById(Long presentId);

  List<ChristmasPresent> findAll();

  List<ChristmasPresent>	findAllById(Set<Long> presentIds);

  Optional<ChristmasPresent> findById(Long id);

  ChristmasPresent save(ChristmasPresent presentFromSanta);

  List<ChristmasPresent> saveAll(List<ChristmasPresent> presentsFromSanta);
}
