package com.bl.day29.practice;

public class AdaptorDesignPatternMain {
    public static void main(String[] args) {
        OldPaymentGateway oldPaymentGateway = new OldPaymentGateway();
        PaymentAdaptor paymentAdaptor = new PaymentAdaptor(oldPaymentGateway);
        paymentAdaptor.pay(500);
    }

}
