package december.christmas.demo.dto.wish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildWishDTO {

  /** ID of a child */
  private String childId;

  /** Wish of a child */
  private String childWish;

  /** Description of a with */
  private String wishDescription;

  /** ID of the book for a child */
  private String bookId;
}