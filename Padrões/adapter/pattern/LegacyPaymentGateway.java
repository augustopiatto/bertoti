public class LegacyPaymentGateway {
    private String lastTransactionId;
    private boolean lastTransactionSuccess;
    
    public String makePayment(String cardInfo, String value) {
        System.out.println("Sistema Legado: Processando pagamento...");
        System.out.println("Cartão: " + cardInfo);
        System.out.println("Valor: " + value);
        
        if (cardInfo != null && cardInfo.contains("|") && value != null) {
            try {
                double amount = Double.parseDouble(value);
                if (amount > 0) {
                    lastTransactionId = "LEG_" + System.currentTimeMillis();
                    lastTransactionSuccess = true;
                    System.out.println("Sistema Legado: Pagamento aprovado - ID: " + lastTransactionId);
                    return lastTransactionId;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sistema Legado: Valor inválido");
            }
        }
        
        lastTransactionSuccess = false;
        System.out.println("Sistema Legado: Pagamento rejeitado");
        return null;
    }
    
    public boolean isLastTransactionApproved() {
        return lastTransactionSuccess;
    }

    public String getLastTransactionId() {
        return lastTransactionId;
    }
}
