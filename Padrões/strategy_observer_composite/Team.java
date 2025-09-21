package strategy_observer_composite;

import java.util.ArrayList;
import java.util.List;

public class Team implements IEmployee {
    private String name;
    private List<IEmployee> employees = new ArrayList<>();
    
    public Team(String name) {
        this.name = name;
    }
    
    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }
    
    public void removeEmployee(IEmployee employee) {
        employees.remove(employee);
    }
    
    @Override
    public void showDetails() {
        System.out.println("Team: " + name);
        for (IEmployee employee : employees) {
            employee.showDetails();
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double calculateSalary(double baseAmount) {
        double total = 0;
        for (IEmployee employee : employees) {
            total += employee.calculateSalary(baseAmount);
        }
        return total;
    }
}
