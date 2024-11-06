package Class6_0310_03;

public class FindEmployeeService {
    private final Repository <String, Employee> repo;

    public FindEmployeeService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public Employee findById(String id){
        return repo.getEntityById(id).orElseThrow(() -> new IllegalArgumentException("employee not found"));
    }
}
