package strategy_observer_composite.model;

public class Manager implements IEmployee {
    private String name;
    private String position;
    
    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + " (" + position + ")");
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double calculateSalary(double baseAmount) {
        return baseAmount * 2.0;
    }
}