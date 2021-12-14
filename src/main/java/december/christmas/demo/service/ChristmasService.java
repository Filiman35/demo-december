package december.christmas.demo.service;

import december.christmas.demo.dao.ChristmasPresent;
import december.christmas.demo.dao.Employee;
import december.christmas.demo.repository.ChristmasPresentRepository;
import december.christmas.demo.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChristmasService {

//  private final ChristmasPresentRepository christmasPresentRepository;
//  private final DirectorRepository directorRepository;

 // public List<ChristmasPresent> getAllPresents() {

//    return christmasPresentRepository.findAll(Sort.by(Sort.Direction.ASC, "description", "id"));
//  }

//  public Page<Employee> getPageWithEmployees() {
//    Pageable directorsSortedByLastNameDesc =
//        PageRequest.of(0, 10, Sort.by("last_name").descending());
//
//    return directorRepository.findAll(directorsSortedByLastNameDesc);
//
//  }
}
