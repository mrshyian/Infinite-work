package com.rekrutacja.infinite.thirdTask.order;

import com.rekrutacja.infinite.thirdTask.Document;

import java.time.LocalDateTime;

public class Order extends Document {
    private final LocalDateTime leadTime;

    public Order(int documentNumber, String documentIssuer, String documentRecipient, LocalDateTime dateOfIssuance, LocalDateTime leadTime) {
        super(documentNumber, documentIssuer, documentRecipient, dateOfIssuance);
        this.leadTime = leadTime;
    }

    @Override
    public double getRabat() {
        if (documentRecipient.equals("Grzegorz Brzęczyszczykiewicz")) {
            return 0.25;
        } else if (documentRecipient.equals("Franek Dolas")) {
            return 0.1;
        } else {
            return 0;
        }
    }

    public LocalDateTime getLeadTime() {
        return leadTime;
    }
}
