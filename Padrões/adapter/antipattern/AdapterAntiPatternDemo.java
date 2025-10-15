public class AdapterAntiPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO ANTI-PATTERN ADAPTER ===\n");
        
        demonstrateProblems();
    }
    
    private static void demonstrateProblems() {
        System.out.println("--- Problema 1: Sistema Acoplado ---");
        
        PaymentSystemCoupled coupledSystem = new PaymentSystemCoupled();
        
        System.out.println("Tentando processar pagamento através do sistema acoplado:");
        
        boolean result1 = coupledSystem.processPayment(100.0, "USD", "1234567890");
        System.out.println("Resultado 1: " + (result1 ? "SUCESSO" : "FALHA"));
        if (!result1) {
            System.out.println("Erro: " + coupledSystem.getLastError());
        }
        
        System.out.println("\n--- Problema 2: Uso Direto do Sistema Legado Modificado ---");
        
        LegacyPaymentService legacyService = coupledSystem.getLegacyService();
        
        System.out.println("Usando método original do sistema legado:");
        String legacyResult1 = legacyService.processLegacyPayment("1234567890|USD|100.0");
        System.out.println("Resultado legado original: " + legacyResult1);
        
        System.out.println("Usando método ADICIONADO ao sistema legado:");
        boolean legacyResult2 = legacyService.processModernPayment(100.0, "USD", "1234567890");
        System.out.println("Resultado legado modificado: " + legacyResult2);
        
        System.out.println("Usando OUTRO método adicionado ao sistema legado:");
        String legacyResult3 = legacyService.processPaymentWithValidation("1234567890", "USD", 100.0);
        System.out.println("Resultado com validação: " + legacyResult3);
        
        System.out.println("\n--- Problema 3: Inconsistências e Efeitos Colaterais ---");
        
        System.out.println("Estado após processamentos:");
        System.out.println("Último cartão processado: " + legacyService.getLastProcessedCard());
        System.out.println("Contador de transações: " + legacyService.getTransactionCounter());
        
        System.out.println("\nTestando moeda não suportada:");
        try {
            coupledSystem.processPayment(50.0, "JPY", "9876543210");
        } catch (RuntimeException e) {
            System.out.println("EXCEÇÃO capturada: " + e.getMessage());
        }
        
        System.out.println("\n--- Problema 4: Dificuldade de Teste e Debug ---");
        
        coupledSystem.setDebugMode(false);
        System.out.println("Processando com debug desligado (ainda há prints internos):");
        boolean result2 = coupledSystem.processPayment(200.0, "EUR", "1111222233334444");
        
        System.out.println("Formatação usando método estático mal posicionado: " + 
                          PaymentSystemCoupled.formatCurrency(200.0, "EUR"));
        
        System.out.println("\n--- Problema 5: Violação de Encapsulamento ---");
        
        legacyService.setLastProcessedCard("CARTAO_MODIFICADO_EXTERNAMENTE");
        legacyService.debugTransaction("DEBUG_EXTERNO");
    }
}
