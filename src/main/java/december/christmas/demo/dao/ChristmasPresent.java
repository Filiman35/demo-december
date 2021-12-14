package december.christmas.demo.dao;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "CHRISTMAS_PRESENT")
@Builder
public class ChristmasPresent {

  /** ID of the present */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /** Description of the present */
  private String description;
}
