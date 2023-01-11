package com.rekrutacja.infinite.fourthTask;


import org.springframework.cache.annotation.Cacheable;

public class InvoiceService {
    private InvoiceRepository repository;
    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }
    @Cacheable(cacheNames= "Invoices", key="#invoiceNumber")
    public Invoice getInvoice(String invoiceNumber) {
        return repository.find(invoiceNumber);
    }
}
