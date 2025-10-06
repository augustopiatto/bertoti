package strategy.antipattern;

public class StrategyAntiPatternDemo {
    public static void main(String[] args) {
        BaseShoppingCart creditCart = new CreditCardShoppingCart(100);
        BaseShoppingCart paypalCart = new PayPalShoppingCart(200);
        
        creditCart.checkout();
        paypalCart.checkout();
    }
}
