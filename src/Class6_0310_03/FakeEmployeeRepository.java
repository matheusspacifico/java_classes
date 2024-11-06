package Class6_0310_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FakeEmployeeRepository implements Repository<String, Employee> {
    private final List<Employee> employees;

    public FakeEmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void save(Employee entity) {
        employees.add(entity);
    }

    @Override
    public Optional<Employee> getEntityById(String id) {
        for (Employee e : employees) {
            if (Objects.equals(e.getId(), id)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}
