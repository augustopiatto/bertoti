package strategy_observer_composite;

public interface IPaymentStrategy {
    void pay(String recipient, double amount);
}
