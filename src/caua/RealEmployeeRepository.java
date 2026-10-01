package caua;

import java.util.HashMap;
import java.util.Map;

public class RealEmployeeRepository implements Repository<String, Employee> {
    private final Map<String, Employee> employees;

    public RealEmployeeRepository() {
        employees = new HashMap<>();
    }

    @Override
    public void saveEntity(Employee entity) {
        employees.put(entity.getId(), entity);
    }

    @Override
    public Employee find(String id) {
        return employees.get(id);
    }
}
