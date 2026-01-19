package com.bl.day30.invoicegenerator;

public class InvoiceService {
    private final RideRepository repository;
    private final InvoiceGenerator generator;

    public InvoiceService(RideRepository repository) {
        this.repository = repository;
        this.generator = new InvoiceGenerator();
    }

    public InvoiceSummary getInvoice(String userId) {
        Ride[] rides = repository.getRides(userId);
        return generator.calculateInvoice(rides);
    }
}
