package december.christmas.demo.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  /** ID of the book */
  String bookId;

  /** Name of the book */
  String bookName;

  /** Author of the book */
  String bookAuthor;
}
