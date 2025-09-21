package strategy_observer_composite;

public class StrategyObserverCompositeDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO INTEGRADO - COMPOSITE + STRATEGY + OBSERVER ===\n");
        
        Developer dev1 = new Developer("Ana Silva", "Senior");
        Developer dev2 = new Developer("Carlos Santos", "Pleno");
        Developer dev3 = new Developer("Maria Oliveira", "Junior");
        
        Team devTeam = new Team("Equipe de Desenvolvimento");
        devTeam.addEmployee(dev1);
        devTeam.addEmployee(dev2);
        devTeam.addEmployee(dev3);
        
        Manager manager = new Manager("João Pereira", "CTO");
        Team managementTeam = new Team("Gestão Executiva");
        managementTeam.addEmployee(manager);
        managementTeam.addEmployee(devTeam);
        
        PaymentNotificationSystem notificationSystem = new PaymentNotificationSystem();
        
        PaymentDisplay emailNotifier = new PaymentDisplay("Notificação por Email");
        PaymentDisplay smsNotifier = new PaymentDisplay("Notificação por SMS");
        PaymentDisplay appNotifier = new PaymentDisplay("Notificação no App");
        
        notificationSystem.registerObserver(emailNotifier);
        notificationSystem.registerObserver(smsNotifier);
        notificationSystem.registerObserver(appNotifier);
        
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        
        System.out.println("--- Processamento de Pagamentos ---");
        
        paymentProcessor.setPaymentStrategy(new CreditCardPayment());
        paymentProcessor.processPayment(managementTeam, 5000, notificationSystem);
        
        System.out.println("\n--- Removendo notificação por SMS ---");
        notificationSystem.removeObserver(smsNotifier);
        
        paymentProcessor.setPaymentStrategy(new PayPalPayment());
        paymentProcessor.processPayment(devTeam, 1500, notificationSystem);
        
        System.out.println("\n--- Estrutura Completa da Empresa ---");
        managementTeam.showDetails();
    }
}
