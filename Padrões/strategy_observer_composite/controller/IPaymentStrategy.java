package strategy_observer_composite.controller;

public interface IPaymentStrategy {
    void pay(String recipient, double amount);
}