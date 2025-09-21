package strategy_observer_composite;

public class PaymentProcessor {
    private IPaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void processPayment(IEmployee employee, double baseAmount, PaymentNotificationSystem notifier) {
        double amount = employee.calculateSalary(baseAmount);
        paymentStrategy.pay(employee.getName(), amount);
        notifier.setPayment(employee.getName(), amount, paymentStrategy.getClass().getSimpleName());
    }
}
