package Class6_0310_03;

public class RegisterEmployeeService {
    private final Repository <String, Employee> repo;

    public RegisterEmployeeService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public void register(Employee e){
        if (repo.getEntityById(e.getId()).isPresent()) throw new IllegalArgumentException("employee already registered");
        repo.save(e);
    }
}
