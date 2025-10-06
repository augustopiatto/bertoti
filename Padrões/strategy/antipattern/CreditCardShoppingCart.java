package strategy.antipattern;

public class CreditCardShoppingCart extends BaseShoppingCart {
    public CreditCardShoppingCart(int amount) {
        super(amount);
    }

    @Override
    public void checkout() {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}