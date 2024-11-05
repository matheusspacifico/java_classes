package Class5_2609_2;

import java.time.LocalDate;

public final class PerHourEmployee extends Employee {
    private final double hourlyRate;
    private final int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    public double salary(){
        return workedHour * hourlyRate;
    }
}
