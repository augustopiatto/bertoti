package strategy.antipattern;

public class PayPalShoppingCart extends BaseShoppingCart {
    public PayPalShoppingCart(int amount) {
        super(amount);
    }

    @Override
    public void checkout() {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}