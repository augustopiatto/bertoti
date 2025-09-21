package strategy_observer_composite;

public class Developer implements IEmployee {
    private String name;
    private String level;
    
    public Developer(String name, String level) {
        this.name = name;
        this.level = level;
    }
    
    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + " (" + level + ")");
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double calculateSalary(double baseAmount) {
        double multiplier = 1.0;
        switch (level.toLowerCase()) {
            case "senior": multiplier = 1.5; break;
            case "pleno": multiplier = 1.2; break;
            case "junior": multiplier = 1.0; break;
        }
        return baseAmount * multiplier;
    }
}
