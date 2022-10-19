package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Abonement {
    public static int count =0;
    private int id;
    private LocalDate registred ;
    private LocalDate expired;
    private LocalTime start;        //= LocalTime.of(8,0); //  дополнительно ставить время
    private LocalTime end;         // = LocalTime.of(22,0); //   //constructor ??
    private Person person;
    private String [] zones;


     Abonement( LocalDate registred, LocalTime start, LocalTime end, String[] zones){
         if (zones == null)
             throw  new IllegalArgumentException("wrong zones data");
        this.id = ++count;
        this.registred = registred;
        this.start = start;
        this.end = end;
        this.zones = zones;
     }

     public void setPerson(Person person){

         this.person = Objects.requireNonNull(person,"wrong person data");
     }

     public void setExpired(LocalDate time) {
         this.expired = Objects.requireNonNull(time,"wrong time data");
    }

    public LocalDate getRegistred() {
        return registred;
    }

    public Person getPerson() {
        return person;
    }

    public String[] getZones() {
        return zones;
    }
    public LocalDate getExpired(){
         return expired;
    }

    public LocalTime getEnd() {
        return end;
    }

    public LocalTime getStart() {
        return start;
    }
}
