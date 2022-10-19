package FitnessAndClients;

public class Person {
  private String name;
  private String surName;
  private int birthDate;



  public Person(String name, String surName, int birthDate) {
      if (name == null || name.length()<3 || surName == null || surName.length()<3 || birthDate > 2018)
          throw new IllegalArgumentException("Wrong Client data");
    this.name = name;
    this.surName = surName;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public String getSurName() {
    return surName;
  }

  public int getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return "Personen{" +
            "name='" + name + '\'' +
            ", surName='" + surName + '\'' +
            ", birthDate=" + birthDate +
            '}';
  }
}

