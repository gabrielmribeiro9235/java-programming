package caua;

public class FakeEmployeeRepository implements Repository<String, Employee> {
    private final Employee[] employees;
    private int numberOfEmployees;

    public FakeEmployeeRepository() {
        employees = new Employee[100];
    }

    @Override
    public void saveEntity(Employee entity) {
        employees[numberOfEmployees++] = entity;
    }

    @Override
    public Employee find(String id) {
        if (id == null) return null;

        for (int i = 0; i < numberOfEmployees; i++) {
            if (employees[i].getId().equals(id)) return employees[i];
        }

        return null;
    }
}
