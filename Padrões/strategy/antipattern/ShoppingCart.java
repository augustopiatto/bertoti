package strategy.antipattern;

public class ShoppingCart {
    public void checkout(String paymentType, int amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Paid " + amount + " using Credit Card.");
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }
}
