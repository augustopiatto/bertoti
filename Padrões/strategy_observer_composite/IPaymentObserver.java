package strategy_observer_composite;

public interface IPaymentObserver {
    void update(String recipient, double amount, String paymentMethod);
}
