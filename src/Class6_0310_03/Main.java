package Class6_0310_03;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FakeEmployeeRepository repository = new FakeEmployeeRepository();
        RegisterEmployeeService registerService = new RegisterEmployeeService(repository);
        FindEmployeeService findService = new FindEmployeeService(repository);

        Employee employee = new Employee("123", "Alice", "Developer", 75000, LocalDate.of(2015, 6, 10));

        try {
            registerService.register(employee);
            System.out.println("Employee registered successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Employee foundEmployee = findService.findById("123");
            System.out.println("Found Employee: " + foundEmployee.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
