package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fitness {
    private Abonement[] swimmimgpool = new Abonement[20];
    private Abonement[] powerLift = new Abonement[20];
    private Abonement[] groupExercise = new Abonement[20];

    public Abonement[] getSwimmimgpool() {
        return swimmimgpool;
    }

    public Abonement[] getPowerLift() {
        return powerLift;
    }

    public Abonement[] getGroupExercise() {
        return groupExercise;
    }

    public static void printer(Abonement abonement, Zone zone){
        System.out.println(abonement.getPerson().getName()+" "+abonement.getPerson().getSurName()+" "
                +" зарегистрирован в " +zone.toString());
    }

    public void printPersonsInClub(){
        System.out.println(" В клубе зарегистрированы :");
        System.out.println(" Зона "+ Zone.SWIMMING_POOL);
        for (Abonement a : swimmimgpool){
            if (a != null)
                System.out.println(a.getPerson());
        }
        System.out.println(" Зона "+ Zone.POWER_LIFT);
        for (Abonement a : powerLift){
            if (a != null)
                System.out.println(a.getPerson());
        }
        System.out.println(" Зона "+ Zone.GROUP);
        for (Abonement a : groupExercise){
            if (a != null)
                System.out.println(a.getPerson());
        }
    };

    public void addVisitor(Abonement abonement, Zone zone) {
        if (abonement == null || zone == null)
            throw new IllegalArgumentException(" abon or zon is null");
        // 1. Устанавливаем дату и время входа в клуб
        LocalDate enterDate = LocalDate.now();
        LocalTime enterTime = LocalTime.now();
        // 2. Сверяем зоны отдыха
        int countMatchedZones = 0;
        for (int i = 0; i < abonement.getZones().length; i++) {
            if (abonement.getZones()[i].equals(zone.toString()))
                countMatchedZones++;
        }
        if (countMatchedZones == 0) {
            System.out.println("Ваш абонемент не имеет доступа в указанную зону");
            return;
        }
        // 3 . сверяем время и дату
        if (!((abonement.getExpired().isEqual(enterDate) || abonement.getExpired().isAfter(enterDate)) && abonement.getStart().isBefore(enterTime)
                && abonement.getEnd().isAfter(enterTime))) {
            System.out.println("Ваш абонемент просрочен или закодирован на другое время посещения");
            return;
        }
        //  Сверяем зону доступа
        if (zone == Zone.SWIMMING_POOL) {
                for (int i = 0; i < swimmimgpool.length; i++) {
                    if (swimmimgpool[i] == null) {
                        swimmimgpool[i] = abonement;
                        printer(abonement, zone);
                        System.out.println("дата посещения : "+enterDate+ " время посещения : "+enterTime);
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
                        System.out.println("дата посещения : "+enterDate+ " время посещения : "+enterTime);
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
                        System.out.println("дата посещения : "+enterDate+ " время посещения : "+enterTime);
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

