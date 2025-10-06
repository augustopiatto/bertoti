package strategy_observer_composite.controller;

public class CreditCardPayment implements IPaymentStrategy {
    @Override
    public void pay(String recipient, double amount) {
        System.out.println("💳 Pagamento de R$ " + amount + " para " + recipient + " via Cartão de Crédito");
    }
}