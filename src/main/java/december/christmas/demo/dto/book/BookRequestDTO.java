package december.christmas.demo.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BookRequestDTO {

  /** Search filter to find books by names or author names */
  BookFilter filter;
}
