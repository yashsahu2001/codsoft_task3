package org.codsoft;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDFGenerator {
    public static void generatePDF(ArrayList<String> transactions) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Transactions.pdf"));
            document.open();
            for (String transaction : transactions) {
                document.add(new Paragraph(transaction));
            }
            document.close();
            System.out.println("PDF created successfully.");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
