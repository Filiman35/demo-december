package december.christmas.demo.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** Inner DTO that is used in {@link BookRequestDTO} */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookFilter {

  /** List of book names in request */
  List<String> bookNames;

  /** List of book authors in request */
  List<String> bookAuthors;
}
