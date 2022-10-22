package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Abonement {
    public static int count =0;
    private int id;
    private LocalDate registred ;
    private LocalDate expired;
    private Person person;
    private AbonementType type;



     Abonement( LocalDate registred, AbonementType type ){
         if (registred == null || type == null || registred.isAfter(LocalDate.now()))
             throw  new IllegalArgumentException("wrong  data");
        this.id = count++;
        this.registred = registred;
        this.type = type;

     }

     public void setPerson(Person person){

         this.person = Objects.requireNonNull(person,"wrong person data");
     }

     public void setExpired(LocalDate time)
     {
         if ( time == null || time.isBefore(registred) || time.isBefore(LocalDate.now()) )
             throw new IllegalArgumentException("wrong time data");
         this.expired = time;
    }

    public LocalDate getRegistred() {
        return registred;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getExpired(){ return expired; }

    public AbonementType getType() {
        return type;
    }
}
