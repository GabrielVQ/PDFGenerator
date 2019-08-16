package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.*;

public class PDFGenerator {

        // Fonts definitions (Definición de fuentes).
        private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

        private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
        private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.BOLD);

    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }

            document.open();
            //Paragraph parrafo1 = new Paragraph("test", categoryFont);
            //DottedLineSeparator dottedline = new DottedLineSeparator();
            //dottedline.setOffset(-2);
            //dottedline.setGap(2f);
            //parrafo1.add(dottedline);

            //tabla identificacion de los solicitantes
            PdfPCell columnHeader;
            int numColumns = 5;
            int numRows = 4;
            String labels[] = {"Lider de Actividad", "Disciplina", "Empresa", "Celular"};
            PdfPTable tabla1 = new PdfPTable(4);
            for (int column = 0; column < 4; column++) {
                columnHeader = new PdfPCell(new Phrase(labels[column]));
                columnHeader.setBackgroundColor(BaseColor.CYAN);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla1.addCell(columnHeader);
            }
            tabla1.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                    tabla1.addCell("Row " + row + " - Col" + column);
                }
            }
            //tabla 2

            PdfPTable tabla2 = new PdfPTable(numColumns);
            for (int column = 0; column < numColumns; column++) {
                columnHeader = new PdfPCell(new Phrase("COL" + column));
                columnHeader.setBackgroundColor(BaseColor.CYAN);
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla2.addCell(columnHeader);
            }
            tabla1.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                    tabla2.addCell("Row " + row + " - Col" + column);
                }
            }
            //parrafo1.add(tabla1);
            PdfPTable tabla3 = new PdfPTable(3);
            //table.setWidths(new float[] {1.5f,1.75f/2,1.75f/2,0.3f,-0.3f+3.5f/2+0.7f+0.6f});
            Paragraph parrafo = new Paragraph("Este permiso debe ser presentado por lo menos con 48 horas de anticipación por el lider de la actividad", smallBold);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            //titulo tabla 1
            PdfPTable label1 = new PdfPTable(1);
            Paragraph celda = new Paragraph(new Paragraph("1.- Identificación de los solicitantes (solo Supervisores)", smallBold));
            PdfPCell cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label1.addCell(cl);
            //titulo tabla 2
            PdfPTable label2 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("2.- Identificación del Área a bloquear", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label2.addCell(cl);

            PdfPTable tabla4 = new PdfPTable(4);
            PdfPTable solicitantesTable = new PdfPTable(5);
            PdfPTable areatable = new PdfPTable(3);
            //document.add(parrafo1);
            headLabel(tabla3);
            solicitantesHeader(tabla4);
            solicitantesTabla(solicitantesTable);
            areaTable(areatable);
            //document.add(tabla1);
            //document.add(tabla2);
            document.add(tabla3);
            document.add(parrafo);
            document.add(label1);
            document.add(tabla4);
            document.add(solicitantesTable);
            document.add(label2);
            document.add(areatable);
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
        void headLabel(PdfPTable table){
            Font title = new Font(Font.FontFamily.HELVETICA, 7);
            Font contentBold = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD);
            Font content = new Font(Font.FontFamily.HELVETICA, 9);
            //Logo
            Paragraph celda = new Paragraph();
            celda.add(new Paragraph("Logo",contentBold));
            PdfPCell cl =new PdfPCell(celda);
            cl.setBackgroundColor(new BaseColor(128,255,255));
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl.setBorder(Rectangle.LEFT | Rectangle.BOTTOM | Rectangle.TOP);
            table.addCell(cl);

            //Celda de al medio
            celda = new Paragraph();
            celda.add(new Paragraph("Hoja de Permiso y Registro de Bloqueos",title));
            celda.add("\n");
            celda.add(new Paragraph("(Pyrblo)",content));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(new BaseColor(128,255,255));
            cl.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cl);

            //Celda derecha
            celda = new Paragraph();
            celda.add(new Paragraph("PMChS", contentBold));
            celda.add("\n");
            celda.add(new Paragraph("Proyecto Mina", contentBold));
            celda.add("\n");
            celda.add(new Paragraph("Chuquicamata", contentBold));
            celda.add("\n");
            celda.add(new Paragraph("Subterráneo", contentBold));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(new BaseColor(128,255,255));
            cl.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cl);
        }
        void solicitantesHeader(PdfPTable table){
            Font title = new Font(Font.FontFamily.HELVETICA, 7);
            Font contentBold = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD);
            Font content = new Font(Font.FontFamily.HELVETICA, 9);
            //celda lider
            BaseColor color = new BaseColor(128,255,255);
            Paragraph celda = new Paragraph();
            celda.add(new Paragraph("Lider de Actividad", contentBold));
            PdfPCell cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cl);
            celda = new Paragraph();
            celda.add(new Paragraph("Disciplina", contentBold));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cl);
            celda = new Paragraph();
            celda.add(new Paragraph("Empresa", contentBold));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cl);
            celda = new Paragraph();
            celda.add(new Paragraph("Celular", contentBold));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cl);

        }
        void solicitantesTabla (PdfPTable table){
            Font title = new Font(Font.FontFamily.HELVETICA, 7);
            Font contentBold = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD);
            Font content = new Font(Font.FontFamily.HELVETICA, 9);
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int filas = 4;//asignar despues con valores dinamicos
            int columnas = 5;
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if(j == 0){
                        celda.add(new Paragraph(Integer.toString(i+1), contentBold));
                    }
                    else{
                        celda.add(new Paragraph(" ", contentBold));//asignar dinamicamente luego
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }
        }
        void areaTable(PdfPTable table){
            Font title = new Font(Font.FontFamily.HELVETICA, 7);
            Font contentBold = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD);
            Font content = new Font(Font.FontFamily.HELVETICA, 9);
            int filas =3;
            int columnas =3;
            String label[] = {"Equipo o Sistema", "Área de Bloqueo (OIM/DIS/DPM/ETC)", "Tag o Sistema"};
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i]));
                cl = new PdfPCell(celda);
                table.addCell(cl);
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    celda.add(new Paragraph(" ")); //agregar dinamicamente
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
            }
        }
    }
