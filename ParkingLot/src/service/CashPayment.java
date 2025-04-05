package service;

public class CashPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processed amount "+amount +" by cash");
        return true;
    }
}
