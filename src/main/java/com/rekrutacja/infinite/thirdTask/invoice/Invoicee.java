package com.rekrutacja.infinite.thirdTask.invoice;

import com.rekrutacja.infinite.thirdTask.Document;

import java.time.LocalDateTime;

public class Invoicee extends Document {
    private final InvoiceType invoiceType;

    public Invoicee(int documentNumber, String documentIssuer, String documentRecipient, LocalDateTime dateOfIssuance, InvoiceType invoiceType) {
        super(documentNumber, documentIssuer, documentRecipient, dateOfIssuance);
        this.invoiceType = invoiceType;
    }


    public double getRabat() {
        switch (invoiceType) {
            case FAKTURA_VAT_PODSTAWOWA, PRO_FORMA -> { return 0.25; }
            case FAKTURA_ZALICZKOWA -> { return 0.19; }
            case FAKTURA_UPROSZCZONA, REFAKTUROWANIE, SAMOFAKTUROWANIE -> { return 0.1; }
            case FAKTURA_VAT_MARZA -> { return 0.15; }
            case FAKTURA_VAT_RR -> { return 0.12; }
            case FAKTURA_ELEKTRONICZNA -> { return 0.11; }
        }
        return 0;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }
}
