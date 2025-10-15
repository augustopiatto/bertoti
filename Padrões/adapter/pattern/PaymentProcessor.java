public interface PaymentProcessor {
    boolean processPayment(double amount, String currency, String cardNumber);

    String getTransactionStatus();
}
