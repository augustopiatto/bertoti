package composity.pattern;

import java.util.ArrayList;
import java.util.List;

class Team extends Employee {
    private List<Employee> employees = new ArrayList<>();

    public Team(String name) {
        super(name);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Team: " + name);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}
