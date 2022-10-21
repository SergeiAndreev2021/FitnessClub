package FitnessAndClients;

import java.time.LocalDate;

public class Person {
  private String name;
  private String surName;
  private int birthYear;



  public Person(String name, String surName, int birthYear) {
      if (name == null || name.length()<3 || surName == null || surName.length()<3
              || LocalDate.of(birthYear,1,1).isAfter(LocalDate.now().minusYears(5)))
          throw new IllegalArgumentException("Wrong Client data");
    this.name = name;
    this.surName = surName;
    this.birthYear = birthYear;
  }

  public String getName() {
    return name;
  }

  public String getSurName() {
    return surName;
  }


  @Override
  public String toString() {
    return "Personen{" +
            "name='" + name + '\'' +
            ", surName='" + surName + '\'' +
            ", birthYear =" + birthYear +
            '}';
  }
}

