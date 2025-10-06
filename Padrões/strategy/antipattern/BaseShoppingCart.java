package strategy.antipattern;

public abstract class BaseShoppingCart {
    protected int amount;

    public BaseShoppingCart(int amount) {
        this.amount = amount;
    }

    public abstract void checkout();
}