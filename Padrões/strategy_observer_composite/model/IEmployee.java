package strategy_observer_composite.model;

public interface IEmployee {
    void showDetails();
    String getName();
    double calculateSalary(double baseAmount);
}