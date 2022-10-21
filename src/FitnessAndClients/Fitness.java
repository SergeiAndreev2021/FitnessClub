package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fitness {
    private Abonement[] swimmimgpool = new Abonement[20];
    private Abonement[] powerLift = new Abonement[20];
    private Abonement[] groupExercise = new Abonement[20];

    public  void printer(Abonement abonement, Zone zone){
        System.out.println(abonement.getPerson().getName()+" "+abonement.getPerson().getSurName()+" "
                +" зарегистрирован в " +zone.toString());
    }

    public void printZonePersons(Abonement[] ab){
        if ( ab == null) throw new IllegalArgumentException("wromg abonement bunch data");
        for (Abonement a : ab){
            if (a != null)  System.out.println(a.getPerson());
        }
    }
    public void printPersonsInClub(){
        System.out.println(" В клубе зарегистрированы :");
        System.out.println(" Зона "+ Zone.SWIMMING_POOL);
        printZonePersons(swimmimgpool);
        System.out.println(" Зона "+ Zone.POWER_LIFT);
        printZonePersons(powerLift);
        System.out.println(" Зона "+ Zone.GROUP);
        printZonePersons(groupExercise);
    }
    // метод на соответствие зоны абонемента с желаемой зоной клиента
    public boolean isCorrectZone(Abonement abonement, Zone zone){
        for (int i = 0; i < abonement.getType().getZones().length; i++) {
            if (abonement.getType().getZones()[i].equals(zone))
                return true;
        }
        return false;
    }

    public void addVisitor(Abonement abonement, Zone zone) {
        if (abonement == null || zone == null)
            throw new IllegalArgumentException(" abon or zon is null");

        // 1. Устанавливаем дату и время входа в клуб
        LocalDate enterDate = LocalDate.now();
        LocalTime enterTime = LocalTime.now();

        // 2. Сверяем зоны отдыха
        if (!isCorrectZone(abonement,zone)) System.out.println("По вашему абонементу доступ в желаемую зону отсутствует");

        // 3 . сверяем время и дату
        if (!((abonement.getExpired().isEqual(enterDate) || abonement.getExpired().isAfter(enterDate)) && abonement.getType().getStart().isBefore(enterTime)
                && abonement.getType().getEnd().isAfter(enterTime))) {
            System.out.println("Ваш абонемент просрочен или закодирован на другое время посещения");
            return;
        }
        //  Сверяем зону доступа
        if (zone == Zone.SWIMMING_POOL) {
            for (int i = 0; i < swimmimgpool.length; i++) {
                if (swimmimgpool[i] == null) {
                    swimmimgpool[i] = abonement;
                    printer(abonement, zone);
                    System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);
                    return;
                }
            }
            System.out.println(" Зона заполнена, приходите позднее!!");
        }
        if (zone == Zone.POWER_LIFT) {
            for (int i = 0; i < powerLift.length; i++) {
                if (powerLift[i] == null) {
                    powerLift[i] = abonement;
                    printer(abonement, zone);
                    System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);
                    return;
                }
            }
            System.out.println("Зона заполнена, приходите позднее!!");
        }


        if (zone == Zone.GROUP) {
            for (int i = 0; i < groupExercise.length; i++) {
                if (groupExercise[i] == null) {
                    groupExercise[i] = abonement;
                    printer(abonement, zone);
                    System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);
                    return;
                }
            }
            System.out.println(" Зона заполнена, приходите позднее!!");
        }
    }



    public void fitnessSetCloseStatus(){
        swimmimgpool = new Abonement[20];
        groupExercise = new Abonement[20];
        powerLift = new Abonement[20];
    }

}





