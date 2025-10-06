package strategy_observer_composite.controller;

public interface IPaymentObserver {
    void update(String recipient, double amount, String paymentMethod);
}