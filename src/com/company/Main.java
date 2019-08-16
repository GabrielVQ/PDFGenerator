package com.company;

import PDF.PDFGenerator;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        PDFGenerator generatePDFFileIText = new PDFGenerator();
        generatePDFFileIText.createPDF(new File("/home/hsecurity/PDF/ejemplo.pdf"));
    }
}
