public class PaymentSystemCoupled {
    private LegacyPaymentService legacyService;
    
    private String lastError;
    private boolean debugMode = true;
    
    public PaymentSystemCoupled() {
        this.legacyService = new LegacyPaymentService();
    }

    public boolean processPayment(double amount, String currency, String cardNumber) {
        if (amount <= 0) {
            lastError = "Valor inválido";
            if (debugMode) {
                System.out.println("ERRO: " + lastError);
            }
            return false;
        }
        
        if (cardNumber == null || cardNumber.length() < 10) {
            lastError = "Cartão inválido";
            if (debugMode) {
                System.out.println("ERRO: " + lastError);
            }
            return false;
        }
        
        String legacyFormat;
        if (currency.equals("USD")) {
            legacyFormat = cardNumber + "|DOLLAR|" + amount;
        } else if (currency.equals("EUR")) {
            legacyFormat = cardNumber + "|EURO|" + amount;
        } else if (currency.equals("BRL")) {
            legacyFormat = cardNumber + "|REAL|" + amount;
        } else {
            throw new RuntimeException("Moeda não suportada: " + currency);
        }
        
        if (debugMode) {
            System.out.println("Convertendo para formato legado: " + legacyFormat);
        }
        
        try {
            String result = legacyService.processLegacyPayment(legacyFormat);
            
            if (result != null && result.startsWith("SUCCESS:")) {
                if (debugMode) {
                    System.out.println("Pagamento processado com sucesso");
                }
                return true;
            } else {
                lastError = "Falha no processamento: " + result;
                if (debugMode) {
                    System.out.println("ERRO: " + lastError);
                }
                return false;
            }
            
        } catch (Exception e) {
            lastError = "Erro interno: " + e.getMessage();
            if (debugMode) {
                System.out.println("EXCEÇÃO: " + lastError);
                e.printStackTrace();
            }
            return false;
        }
    }
    
    public String getLastError() {
        return lastError;
    }
    
    public LegacyPaymentService getLegacyService() {
        return legacyService;
    }
    
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
    
    public static String formatCurrency(double amount, String currency) {
        return currency + " " + String.format("%.2f", amount);
    }
}
