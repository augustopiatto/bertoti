package strategy_observer_composite;

import java.util.ArrayList;
import java.util.List;

public class PaymentNotificationSystem {
    private List<IPaymentObserver> observers = new ArrayList<>();
    private String recipient;
    private double amount;
    private String paymentMethod;
    
    public void registerObserver(IPaymentObserver o) {
        observers.add(o);
    }
    
    public void removeObserver(IPaymentObserver o) {
        observers.remove(o);
    }
    
    private void notifyObservers() {
        for (IPaymentObserver observer : observers) {
            observer.update(recipient, amount, paymentMethod);
        }
    }
    
    public void setPayment(String recipient, double amount, String paymentMethod) {
        this.recipient = recipient;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        notifyObservers();
    }
}
