package com.rekrutacja.infinite.fourthTask;

import java.io.Serializable;

public class Invoice implements Serializable {
    private String invoiceNumber;
    private Object invoiceData;

    public Invoice(String invoiceNumber, Object invoiceData) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceData = invoiceData;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Object getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(Object invoiceData) {
        this.invoiceData = invoiceData;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceData=" + invoiceData +
                '}';
    }
}
