package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Applic {

    public static void main(String[] args) {
      //  зоны посещения
        String [] zonesToVisitFull ={Zone.POWER_LIFT.toString(),Zone.GROUP.toString(),Zone.SWIMMING_POOL.toString()};
        String [] zonesToVisitDay ={Zone.POWER_LIFT.toString(),Zone.GROUP.toString()};
        String [] zonesToVisitOneTime ={Zone.POWER_LIFT.toString(),Zone.SWIMMING_POOL.toString()};

        Person person1 = new Person("Igor","Petrov",1980);
        Person person2 = new Person("Ivan","Efimov",1973);
        Person person3 = new Person("Boris","Borisov",1995);
        Person person4 = new Person("Egor","Egorov",2005);
        Person person5 = new Person("Alexander","Alexandrov",1989);

       Abonement abonement1 = new Abonement(LocalDate.of(2020, Month.FEBRUARY,8), //  дата регистрации абон
                                            LocalTime.of(8,00), // начало доступа в какую-либо зону
                                            LocalTime.of(22,00), // конец доступа в  какую-либо зону
                                            zonesToVisitFull //  массив открытых для доступа зон
                                            );
       abonement1.setExpired(abonement1.getRegistred().plusYears(5)); //  фиксируем срок дейсвия абонемента
       abonement1.setPerson(person1);   // Связываем посетителя с его абонементом

        Abonement abonement2 = new Abonement(LocalDate.of(2022, Month.MARCH,17), //  дата регистрации абон
                LocalTime.of(8,00), // начало доступа в какую-либо зону
                LocalTime.of(16,00), // конец доступа в  какую-либо зону
                zonesToVisitDay //  массив открытых для доступа зон
        );
        abonement2.setExpired(abonement2.getRegistred().plusYears(1));
        abonement2.setPerson(person2);

        Abonement abonement3 = new Abonement(LocalDate.of(2022, Month.OCTOBER,19), //  дата регистрации абон
                LocalTime.of(8,00), // начало доступа в какую-либо зону
                LocalTime.of(22,00), // конец доступа в  какую-либо зону
                zonesToVisitOneTime //  массив открытых для доступа зон
        );
        abonement3.setExpired(abonement3.getRegistred().plusDays(1));
        abonement3.setPerson(person3);

        Abonement abonement4 = new Abonement(LocalDate.of(2022, Month.JULY,11), //  дата регистрации абон
                LocalTime.of(8,00), // начало доступа в какую-либо зону
                LocalTime.of(22,00), // конец доступа в  какую-либо зону
                zonesToVisitFull //  массив открытых для доступа зон
        );
        abonement4.setExpired(abonement4.getRegistred().plusYears(3));
        abonement4.setPerson(person4);


        Abonement abonement5 = new Abonement(LocalDate.of(2022, Month.JANUARY,23), //  дата регистрации абон
                LocalTime.of(8,00), // начало доступа в какую-либо зону
                LocalTime.of(16,00), // конец доступа в  какую-либо зону
                zonesToVisitDay //  массив открытых для доступа зон
        );
        abonement5.setExpired(abonement4.getRegistred().plusYears(3));
        abonement5.setPerson(person4);

        Fitness fitness = new Fitness();
        fitness.addVisitor(abonement1,Zone.SWIMMING_POOL);
        fitness.addVisitor(abonement2,Zone.GROUP);
        fitness.addVisitor(abonement3,Zone.POWER_LIFT);
        fitness.addVisitor(abonement4,Zone.POWER_LIFT);
        fitness.addVisitor(abonement5,Zone.GROUP);
        fitness.printPersonsInClub();
        fitness.fitnessSetCloseStatus();
        fitness.printPersonsInClub();
    }
}
