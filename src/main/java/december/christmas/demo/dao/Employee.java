package december.christmas.demo.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE") // if the name is the same as the name of the entity, can be omitted
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  /** ID of the employee */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /** First name of the employee */
  private String firstName;

  /** Last name of the employee */
  private String lastName;

  /** Gender of the employee */
  private String gender;

  /** Date of birth of the employee */
  private String dateOfBirth;

  /** Country of birth of the employee */
  private String countryOfBirth;

  /** Email of the employee */
  private String email;

  /** Bicycle ID of the employee */
  private Long bicycleId;

  @Override
  public String toString() {
    return String.format(
        "Employee[id=%d, firstName=%s, lastName=%s, gender=%s, dateOfBirth=%s," +
            "countryOfBirth=%s, email=%s, bicycleId=%s]",
        id, firstName, lastName, gender, dateOfBirth, countryOfBirth, email, bicycleId);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public void setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getBicycleId() {
    return bicycleId;
  }

  public void setBicycleId(Long bicycleId) {
    this.bicycleId = bicycleId;
  }
}

