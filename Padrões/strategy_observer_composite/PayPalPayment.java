package strategy_observer_composite;

public class PayPalPayment implements IPaymentStrategy {
    @Override
    public void pay(String recipient, double amount) {
        System.out.println("📧 Pagamento de R$ " + amount + " para " + recipient + " via PayPal");
    }
}
