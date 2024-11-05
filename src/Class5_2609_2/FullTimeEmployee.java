package Class5_2609_2;

import java.time.LocalDate;

public final class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    public double salary(){
        return monthlySalary;
    }
}
