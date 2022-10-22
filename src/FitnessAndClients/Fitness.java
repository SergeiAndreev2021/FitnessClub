package FitnessAndClients;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private Abonement[] swimmimgpool = new Abonement[20];
    private Abonement[] powerLift = new Abonement[20];
    private Abonement[] groupExercise = new Abonement[20];

    public void printer(Abonement abonement, Zone zone) {
        System.out.println(abonement.getPerson().getName() + " " + abonement.getPerson().getSurName() + " "
                + " зарегистрирован в " + zone.toString());
    }

    public void printZonePersons(Abonement[] ab) {
        for (Abonement a : ab) {
            if (a != null) System.out.println(a.getPerson());
        }
    }

    public void printPersonsInClub() {
        System.out.println(" В клубе зарегистрированы :");
        System.out.println(" Зона " + Zone.SWIMMING_POOL);
        printZonePersons(swimmimgpool);
        System.out.println(" Зона " + Zone.POWER_LIFT);
        printZonePersons(powerLift);
        System.out.println(" Зона " + Zone.GROUP);
        printZonePersons(groupExercise);
    }

    // метод на соответствие зоны абонемента с желаемой зоной клиента
    public boolean isCorrectZone(Abonement abonement, Zone zone) {
        for (int i = 0; i < abonement.getType().getZones().length; i++) {
            if (abonement.getType().getZones()[i].equals(zone))
                return true;
        }
        return false;
    }

    public void addElement(Abonement[] ab, Abonement abonement) {
        for (int i = 0; i < ab.length; i++) {
            if (ab[i] == null) {
                ab[i] = abonement;
                return;
            }
            System.out.println(" Зона заполнена, приходите позднее!!");
        }
    }

    public void addVisitor(Abonement abonement, Zone zone) {
        if (abonement == null || zone == null)
            throw new IllegalArgumentException(" abon or zon is null");

        // 1. Устанавливаем дату и время входа в клуб
        LocalDate enterDate = LocalDate.now();
        LocalTime enterTime = LocalTime.now();

        // 2. Сверяем зоны отдыха
        if (!isCorrectZone(abonement, zone)) {
            System.out.println("По вашему абонементу доступ в желаемую зону отсутствует");
            return;
        }
        // 3 . сверяем время и дату
        if (!((abonement.getExpired().isEqual(enterDate) || abonement.getExpired().isAfter(enterDate)) && abonement.getType().getStart().isBefore(enterTime)
                && abonement.getType().getEnd().isAfter(enterTime))) {
            System.out.println("Ваш абонемент просрочен или закодирован на другое время посещения");
            return;
        }

        //  Сверяем зону доступа
        if (zone == Zone.SWIMMING_POOL) {
            addElement(swimmimgpool, abonement);
            printer(abonement, zone);
            System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);
        }
        if (zone == Zone.POWER_LIFT) {
            addElement(powerLift, abonement);
            printer(abonement, zone);
            System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);
        }

        if (zone == Zone.GROUP) {
           addElement(groupExercise,abonement);
           printer(abonement, zone);
           System.out.println("дата посещения : " + enterDate + " время посещения : " + enterTime);

                }
    }

    public void setNull(Abonement[] abonements) {
        Arrays.fill(abonements, null);
    }
    public void fitnessSetCloseStatus() {
        setNull(swimmimgpool);
        setNull(powerLift);
        setNull(groupExercise);
    }
}



