package strategy.pattern;

class PayPalPayment implements IPaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
