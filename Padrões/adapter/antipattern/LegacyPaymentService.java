public class LegacyPaymentService {
    private int transactionCounter = 1000;
    
    public String processLegacyPayment(String paymentData) {
        System.out.println("Sistema Legado Original: Processando " + paymentData);
        
        if (paymentData != null && paymentData.contains("|")) {
            transactionCounter++;
            return "SUCCESS:TXN_" + transactionCounter;
        }
        return "ERROR:INVALID_FORMAT";
    }

    public boolean processModernPayment(double amount, String currency, String cardNumber) {
        System.out.println("Método ADICIONADO: Tentando processar pagamento moderno...");
        
        String legacyFormat = cardNumber + "|" + currency + "|" + amount;
        String result = processLegacyPayment(legacyFormat);
        
        return result != null && result.startsWith("SUCCESS:");
    }
    
    private String lastProcessedCard;
    private double lastAmount;
    
    public String getLastProcessedCard() {
        return lastProcessedCard;
    }
    
    public void setLastProcessedCard(String cardNumber) {
        this.lastProcessedCard = cardNumber;
    }
    
    public String processPaymentWithValidation(String cardNumber, String currency, double amount) {
        System.out.println("Método ADICIONADO: Processamento com validação...");
        
        if (cardNumber == null || cardNumber.isEmpty()) {
            return "ERROR:INVALID_CARD";
        }
        
        if (amount <= 0) {
            return "ERROR:INVALID_AMOUNT";
        }
        
        this.lastProcessedCard = cardNumber;
        this.lastAmount = amount;
        
        String legacyData = cardNumber + "|" + currency.toUpperCase() + "|" + amount;
        return processLegacyPayment(legacyData);
    }
    
    public String convertCurrencyFormat(String originalCurrency) {
        switch (originalCurrency.toLowerCase()) {
            case "usd":
            case "dollar":
                return "DOLLAR";
            case "eur":
            case "euro":
                return "EURO";
            case "brl":
            case "real":
                return "REAL";
            default:
                return "UNKNOWN";
        }
    }
    
    public void debugTransaction(String transactionId) {
        System.out.println("DEBUG ADICIONADO: Transação " + transactionId + 
                          " processada. Último cartão: " + lastProcessedCard + 
                          ", Último valor: " + lastAmount);
    }
    
    public int getTransactionCounter() {
        return transactionCounter;
    }
}
