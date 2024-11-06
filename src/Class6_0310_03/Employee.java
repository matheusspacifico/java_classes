package Class6_0310_03;

import java.time.LocalDate;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private final double salary;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        if (LocalDate.now().isBefore(dateOfEmployment)) throw new IllegalArgumentException("that's literally impossible lol");
        return LocalDate.now().getYear() - dateOfEmployment.getYear();
    }

    public double calculateBonus(){
        return salary * 1.1;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

/*
- id: String
- name: String
- jobTitle: String
- salary: double
- dateOfEmployment: LocalDate
+ getYearsOfService(): double
+ calculateBonus(): double
*/