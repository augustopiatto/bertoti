package strategy_observer_composite.view;

import strategy_observer_composite.controller.IPaymentObserver;

public class PaymentDisplay implements IPaymentObserver {
    private String name;
    
    public PaymentDisplay(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String recipient, double amount, String paymentMethod) {
        System.out.println("🔔 " + name + ": Pagamento processado - " + 
                          recipient + " recebeu R$ " + amount + " via " + paymentMethod);
    }
}