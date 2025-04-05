package service;

public class CardPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processed amount "+amount +" by card");
        return true;
    }
}
