package com.bl.day29.practice;

public class PaymentAdaptor implements PaymentProcessor {

    private OldPaymentGateway oldPaymentGateway;

    public PaymentAdaptor(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    @Override
    public void pay(int amount) {
        oldPaymentGateway.makePayment(amount);
    }
}
