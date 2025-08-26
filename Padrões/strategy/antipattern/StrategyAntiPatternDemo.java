package strategy.antipattern;

public class StrategyAntiPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout("CreditCard", 100);
        cart.checkout("PayPal", 200);
    }
}
