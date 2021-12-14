package december.christmas.demo.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Data
@NoArgsConstructor
@SuperBuilder
public class BookResponseDTO<T> {

  private Collection<T> bookList;

  private Long totalNumber;
}
