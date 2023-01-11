package com.rekrutacja.infinite;

import com.rekrutacja.infinite.fourthTask.InvoiceJpaRepository;
import com.rekrutacja.infinite.fourthTask.InvoiceRepository;
import com.rekrutacja.infinite.fourthTask.InvoiceService;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
public class Main {

    public static void main(String[] args) {
//        System.out.println(FirstTask.StringScanner("33;11.22,44+"));





//        LocalDateTime leadTime = LocalDateTime.now().plusDays(10);
//
//        Invoice invoice = new Invoice(1, "dudu", "dada", LocalDateTime.now(), InvoiceType.PRO_FORMA);
//        System.out.println(invoice.getRabat());
//
//        Document document = new Document(111, "fafa", "fofo", LocalDateTime.now());
//        System.out.println(document);
//        document.saveDocumentToFile(FileType.CSV); //zapisywanie do pliku

        InvoiceRepository invoiceRepository = new InvoiceJpaRepository();
        InvoiceService invoiceService = new InvoiceService(invoiceRepository);
        System.out.println(invoiceService.getInvoice("1"));
    }
}
