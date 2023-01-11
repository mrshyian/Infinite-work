package com.rekrutacja.infinite.thirdTask;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int documentNumber;
    private final String documentIssuer;
    protected final String documentRecipient;
    private final LocalDateTime dateOfIssuance;

    public Document(int documentNumber, String documentIssuer, String documentRecipient, LocalDateTime dateOfIssuance) {
        this.documentNumber = documentNumber;
        this.documentIssuer = documentIssuer;
        this.documentRecipient = documentRecipient;
        this.dateOfIssuance = dateOfIssuance;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public String getDocumentIssuer() {
        return documentIssuer;
    }

    public String getDocumentRecipient() {
        return documentRecipient;
    }

    public LocalDateTime getDateOfIssuance() {
        return dateOfIssuance;
    }

    // losowo generuje rabat
    public double getRabat() {
        Random r = new Random();

        double input = 0.05 + (0.35 - 0.005) * r.nextDouble();
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return "documentNumber=" + documentNumber +
                ", documentIssuer='" + documentIssuer + '\'' +
                ", documentRecipient='" + documentRecipient + '\'' +
                ", dateOfIssuance=" + dateOfIssuance.format(formatter);
    }

    public void saveDocumentToFile(FileType fileType) {
        String type = ".txt";
        switch (fileType) {
            case CSV -> type = ".csv";
            case XML -> type = ".xml";
            case HTML -> type = ".html";
        }

        try {
            FileOutputStream fos = new FileOutputStream("zapisane" + type);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.toString());
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
