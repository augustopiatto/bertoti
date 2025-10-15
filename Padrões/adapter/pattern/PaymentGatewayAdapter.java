public class PaymentGatewayAdapter implements PaymentProcessor {
    private LegacyPaymentGateway legacyGateway;
    
    public PaymentGatewayAdapter(LegacyPaymentGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public boolean processPayment(double amount, String currency, String cardNumber) {
        System.out.println("Adapter: Convertendo chamada para o sistema legado...");
        
        String cardInfo = cardNumber + "|" + currency;
        String value = String.valueOf(amount);
        
        String transactionId = legacyGateway.makePayment(cardInfo, value);
        
        boolean success = transactionId != null && legacyGateway.isLastTransactionApproved();
        
        System.out.println("Adapter: Conversão concluída. Resultado: " + (success ? "Sucesso" : "Falha"));
        
        return success;
    }

    @Override
    public String getTransactionStatus() {
        if (legacyGateway.getLastTransactionId() != null) {
            if (legacyGateway.isLastTransactionApproved()) {
                return "APPROVED - Transaction ID: " + legacyGateway.getLastTransactionId();
            } else {
                return "REJECTED";
            }
        }
        return "NO_TRANSACTION";
    }
}
