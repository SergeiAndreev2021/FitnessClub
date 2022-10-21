package FitnessAndClients;

import java.time.LocalTime;

public enum AbonementType {
    MORNING(LocalTime.of(8,00),LocalTime.of(16,00),new Zone[]{Zone.POWER_LIFT,Zone.GROUP}),
    ONE_TIME(LocalTime.of(8,00),LocalTime.of(22,00),new Zone[]{Zone.POWER_LIFT,Zone.SWIMMING_POOL}),
    FULL_ABON(LocalTime.of(8,00),LocalTime.of(22,00),new Zone[]{Zone.POWER_LIFT,Zone.SWIMMING_POOL,Zone.GROUP});

    private LocalTime start;
    private LocalTime end;
    private Zone [] zones;

    AbonementType(LocalTime start, LocalTime end, Zone[] zones) {
        if (start == null || end == null || zones == null || end.isBefore(start))
            throw new IllegalArgumentException("wrong time or/and zone data");
        this.start = start;
        this.end = end;
        this.zones = zones;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public Zone[] getZones() {
        return zones;
    }
}
