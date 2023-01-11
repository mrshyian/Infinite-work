package com.rekrutacja.infinite.fourthTask;

public class InvoiceJpaRepository implements InvoiceRepository {
    @Override
    public Invoice find(final String invoiceNumber) {
        // ... implementation
        return new Invoice("1", new Object());
    }
}
