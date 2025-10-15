public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO PADRÃO ADAPTER ===\n");
        
        PaymentClient client = new PaymentClient();
        
        System.out.println("1. Tentativa de usar o sistema legado diretamente:");
        System.out.println("   (Isso não funcionaria porque as interfaces são incompatíveis)\n");
        
        System.out.println("2. Usando o Adapter para integrar o sistema legado:");
        
        LegacyPaymentGateway legacySystem = new LegacyPaymentGateway();
        
        PaymentProcessor adaptedPayment = new PaymentGatewayAdapter(legacySystem);
        
        client.processClientPayment(adaptedPayment);
    }
}

class PaymentClient {
    public void processClientPayment(PaymentProcessor processor) {
        System.out.println("Cliente: Iniciando processamento de pagamento...");
        
        double amount = 150.75;
        String currency = "USD";
        String cardNumber = "4532-1234-5678-9012";
        
        System.out.println("Cliente: Valor: $" + amount + " " + currency);
        System.out.println("Cliente: Cartão: " + cardNumber);
        System.out.println();
        
        boolean success = processor.processPayment(amount, currency, cardNumber);
        
        System.out.println();
        System.out.println("Cliente: Resultado do pagamento: " + (success ? "SUCESSO" : "FALHA"));
        System.out.println("Cliente: Status: " + processor.getTransactionStatus());
    }
}
