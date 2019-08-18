package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class PDFGenerator {

        // Fonts definitions (Definición de fuentes).
        private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        private static final Font content = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
        private static final Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.WHITE);
        private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);

    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document(PageSize.LETTER, 1,1,4,4);
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }

            document.open();



            //Titulos de tablas

            Paragraph parrafo = new Paragraph("Este permiso debe ser presentado por lo menos con 48 horas de anticipación por el lider de la actividad", smallBold);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            //titulo tabla 1
            PdfPTable label1 = new PdfPTable(1);
            Paragraph celda = new Paragraph(new Paragraph("\n\n1.- Identificación de los solicitantes (solo Supervisores)", smallBold));
            PdfPCell cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label1.setWidthPercentage(95);
            label1.addCell(cl);
            //titulo tabla 2
            PdfPTable label2 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n2.- Identificación del Área a bloquear", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label2.setWidthPercentage(95);
            label2.addCell(cl);

            PdfPTable label3 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n3.- Identificación de requerimiento", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label3.setWidthPercentage(95);
            label3.addCell(cl);

            PdfPTable label4 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n4.- Aprobación", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label4.setWidthPercentage(95);
            label4.addCell(cl);

            PdfPTable label5 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n5.- Verificación de Energía Cero", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label5.setWidthPercentage(95);
            label5.addCell(cl);

            PdfPTable label6 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n6.- Registro de Bloqueo Departamentales Dueño de Área (primer bloqueo)", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label6.setWidthPercentage(95);
            label6.addCell(cl);

            PdfPTable label7 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n7.- Registro de Bloqueo Departamentales Líder de la Actividad", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label7.setWidthPercentage(95);
            label7.addCell(cl);

            PdfPTable label8 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n8.- Registro de Bloqueo Personales", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label8.setWidthPercentage(95);
            label8.addCell(cl);

            PdfPTable label9 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n9.- Observaciones", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label9.setWidthPercentage(95);
            label9.addCell(cl);

            //Color de tablas
            BaseColor color = new BaseColor(43,69,145);
            //Creacion de tablas
            PdfPTable header = new PdfPTable(3);
            header.setWidthPercentage(95);
            header.setWidths(new float[] {0.5f,2.5f,0.8f});
            PdfPTable headersolicitantestable = new PdfPTable(4);
            headersolicitantestable.setWidthPercentage(95);
            headersolicitantestable.setWidths(new float[] {3f,2f,2f,2f});
            PdfPTable solicitantestable = new PdfPTable(5);
            solicitantestable.setWidthPercentage(95);
            solicitantestable.setWidths(new float[] {0.4f,2.6f,2f,2f,2f});
            PdfPTable areatable = new PdfPTable(3);
            areatable.setWidthPercentage(95);
            areatable.setWidths(new float[] {3f,2f,4f});
            PdfPTable headerrequerimiento = new PdfPTable(2);
            headerrequerimiento.setWidthPercentage(95);
            headerrequerimiento.setWidths(new float[] {5f,4f});
            PdfPTable requerimientotable = new PdfPTable(3);
            requerimientotable.setWidthPercentage(95);
            requerimientotable.setWidths(new float[] {5f, 1.5f, 2.5f});
            PdfPTable aprobaciontable = new PdfPTable(5);
            aprobaciontable.setWidthPercentage(95);
            aprobaciontable.setWidths(new float[] {3f, 2f, 2f, 1f, 1f});
            PdfPTable energiatable = new PdfPTable(6);
            energiatable.setWidthPercentage(95);
            energiatable.setWidths(new float[] {3f, 2f, 1.2f, 1.2f, 0.7f, 0.9f});
            PdfPTable headerbloqueo = new PdfPTable(6);
            headerbloqueo.setWidthPercentage(95);
            headerbloqueo.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f, 2f});
            PdfPTable headerbloqueo2 = new PdfPTable(10);
            headerbloqueo2.setWidthPercentage(95);
            headerbloqueo2.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable bloquerodepartamentalduenotable = new PdfPTable(10);
            bloquerodepartamentalduenotable.setWidthPercentage(95);
            bloquerodepartamentalduenotable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable headerbloqueodepartamentallider = new PdfPTable(6);
            headerbloqueodepartamentallider.setWidthPercentage(95);
            headerbloqueodepartamentallider.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f, 2f});
            PdfPTable bloqueodepartamentallidertable = new PdfPTable(10);
            bloqueodepartamentallidertable.setWidthPercentage(95);
            bloqueodepartamentallidertable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable bloqueopersonaltable = new PdfPTable(10);
            bloqueopersonaltable.setWidthPercentage(95);
            bloqueopersonaltable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable observaciones = new PdfPTable(1);
            observaciones.setWidthPercentage(95);
            //document.add(parrafo1);

            crearHeader(header, color);
            creaHeadersolicitantes(headersolicitantestable, color);
            crearSolicitantesTable(solicitantestable, color);
            crearAreaTable(areatable, color);
            crearHeaderRequerimiento(headerrequerimiento, color);
            crearRequerimientoTable(requerimientotable, color);
            crearAprobacionTable(aprobaciontable, color);
            crearEnergiaTable(energiatable, color);
            crearHeaderBloqueo(headerbloqueo, color);
            crearHeaderBloqueo2(headerbloqueo2, color);
            crearBloqueoDepartamentalDuenoTable(bloquerodepartamentalduenotable, color);
            crearHeaderBloqueoDepartamentalLider(headerbloqueodepartamentallider, color);
            crearBloqueoDepartamentalLiderTable(bloqueodepartamentallidertable, color);
            creaBloqueoPersonalTable(bloqueopersonaltable, color);
            crearObservaciones(observaciones, color);
            //Agregar elementos al documento
            document.add(header);
            document.add(parrafo);
            document.add(label1);
            document.add(headersolicitantestable);
            document.add(solicitantestable);
            document.add(label2);
            document.add(areatable);
            document.add(label3);
            document.add(headerrequerimiento);
            document.add(requerimientotable);
            document.add(label4);
            document.add(aprobaciontable);
            document.add(label5);
            document.add(energiatable);
            document.add(label6);
            document.add(headerbloqueo);
            document.add(headerbloqueo2);
            document.add(bloquerodepartamentalduenotable);
            document.add(label7);
            document.add(headerbloqueodepartamentallider);//header bloqueo sin descripcion
            document.add(headerbloqueo2);
            document.add(bloqueodepartamentallidertable);
            document.add(label8);
            document.add(headerbloqueodepartamentallider);
            document.add(headerbloqueo2);
            document.add(bloqueopersonaltable);
            document.add(label9);
            document.add(observaciones);
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
        private void crearHeader(PdfPTable table, BaseColor color){
            Font title = new Font(Font.FontFamily.HELVETICA, 11);
            Font headerFont1 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
            Font content = new Font(Font.FontFamily.HELVETICA, 13);
            //celda logo
            Paragraph celda = new Paragraph();

            String url = "src/Resources/Codelco_logo1.png";
            Image image;
            try {
                image = Image.getInstance(url);
                image.scalePercent(4,4);// tamaño de la imagen
                image.setAlignment(Element.ALIGN_CENTER);
                celda.add(new Paragraph(""));//imagen no quede topando con el borde
                PdfPCell cl = new PdfPCell(celda);
                cl.addElement(image);
                cl.setBackgroundColor(color);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                cl.setBorder(Rectangle.LEFT | Rectangle.BOTTOM | Rectangle.TOP);
                table.addCell(cl);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }

            PdfPCell cl;
            //Celda de al medio
            celda = new Paragraph();
            celda.add(new Paragraph("Hoja de Permiso y Registro de Bloqueos",title));
            celda.add("\n");
            celda.add(new Paragraph("(Pyrblo)",content));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cl);

            //Celda derecha
            celda = new Paragraph();
            celda.add(new Paragraph("PMChS", headerFont1));
            celda.add("\n");
            celda.add(new Paragraph("Proyecto Mina", headerFont1));
            celda.add("\n");
            celda.add(new Paragraph("Chuquicamata", headerFont1));
            celda.add("\n");
            celda.add(new Paragraph("Subterráneo", headerFont1));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cl);
        }

        private void creaHeadersolicitantes(PdfPTable table, BaseColor color){
            //labels
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columns = table.getNumberOfColumns();
            String label[] = {"Lider de actividad", "Disciplina", "Empresa", "Celular"};
            for (int i = 0; i<columns; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], headerFont));
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cl);
            }
        }
        //tabla de datos solicitantes
        private void crearSolicitantesTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int filas = 4;//asignar despues con valores dinamicos
            int columnas = 5;
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if(j == 0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                    }
                    else{
                        celda.add(new Paragraph(" ", PDFGenerator.headerFont));//asignar dinamicamente luego
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }
        }

        private void crearAreaTable(PdfPTable table, BaseColor color){

            PDFGenerator.headerFont.setColor(BaseColor.WHITE);
            int filas =3;
            int columnas =3;
            String label[] = {"Equipo o Sistema", "Área de Bloqueo (OIM/DIS/DPM/ETC)", "Tag o Sistema"};
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    celda.add(new Paragraph(" ", content)); //agregar
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
            }
        }
        private void crearHeaderRequerimiento(PdfPTable table, BaseColor color){

            int columnas = table.getNumberOfColumns();
            String label[] = {"Trabajo a realizar (Especifique)", "Solicitud de fecha y hora de Bloqueo"};
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            for(int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
        }

        private void crearRequerimientoTable(PdfPTable table, BaseColor color){

            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            color = new BaseColor(149, 168, 222);
            int columnas = table.getNumberOfColumns();
            int filas = 2;
            String label[] = {"Desde (Hora/Fecha)","Hasta (Hora/Fecha)"};
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if(j == 1){
                        celda.add(new Paragraph(new Paragraph(label[i], content)));
                        cl = new PdfPCell(celda);
                        cl.setBackgroundColor(color);
                    }
                    else{
                        celda.add(new Paragraph(new Paragraph(" ", content)));
                        cl = new PdfPCell(celda);
                    }
                    cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cl);
                }
            }
        }

        private void crearAprobacionTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);

            String label[] = {"Dueño de Área de bloqueo", "Fecha/hora envió solicitud", "Aprobación (SI / NO)", "Fecha", "Firma"};
            int columnas = table.getNumberOfColumns();
            int filas = 1;

            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
            for (int i = 0; i<columnas; i++){//agregar datos
                celda = new Paragraph();
                celda.add(new Paragraph(" ", PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
        }

        private void crearEnergiaTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);

            String label[] = {"Nombre del que realiza la Verificación de Energía Cero", "Empresa", "Firma", "Valor medio", "Instrumernto", "Proceder (SI/NO"};
            int columnas = table.getNumberOfColumns();
            int filas = 2;//cambiar
            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
            for (int i = 0; i<filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    celda = new Paragraph();
                    celda.add(new Paragraph(" ", content)); //agregar
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
            }
        }
        private void crearHeaderBloqueo(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            String label[] = {"Núm.", "Nombre", "N°Candado", "Empresa", "Bloqueo (inicio de Bloqueo)", "Desbloqueo (Cierre de Hoja de Bloqueo)"};
            int columnas = table.getNumberOfColumns();
            int filas =2;

            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                //celda.setAlignment(Element.ALIGN_CENTER);
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                //cl.setFixedHeight(12);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                cl.setVerticalAlignment(Element.ALIGN_BOTTOM);
                //cl.setColspan(3);
                cl.setBorder(Rectangle.TOP| Rectangle. LEFT | Rectangle. RIGHT);
                table.addCell(cl);
            }
//            PdfPTable auxtabla = new PdfPTable(3);//tabla fecha/hora/firma
//            String label2[] = {"Fecha", "Hora", "Firma"};
//            for (int i = 0; i<3; i++){
//                celda = new Paragraph();
//                celda.add(new Paragraph(label2[i], headerFont));
//                cl =  new PdfPCell(celda);
//                cl.setBorder(Rectangle.NO_BORDER);
//                cl.setBackgroundColor(color);
//                auxtabla.addCell(cl);
//            }
//            for (int i = 0; i<4; i++){
//                celda = new Paragraph();
//                celda.add(new Paragraph("", headerFont));
//                //celda.setAlignment(Element.ALIGN_CENTER);
//                cl = new PdfPCell(celda);
//                cl.setBackgroundColor(color);
//                //cl.setFixedHeight(8);
//                //cl.setPadding(20);
//                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cl.setVerticalAlignment(Element.ALIGN_BOTTOM);
//                table.addCell(cl);
//            }
//
//            table.addCell(auxtabla);
//            table.addCell(auxtabla);




        }

        private void crearHeaderBloqueo2(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            String label[] = {"Fecha", "Hora", "Firma"};
            for (int i = 0; i<4; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(" ", PDFGenerator.headerFont));
                cl =  new PdfPCell(celda);
                cl.setBackgroundColor(color);
                cl.setBorder(Rectangle.BOTTOM | Rectangle. LEFT | Rectangle. RIGHT);
                table.addCell(cl);
            }

            for ( int i = 0; i<2; i++){
                for (int j = 0; j<3; j++){
                    celda = new Paragraph();
                    celda.add(new Paragraph(label[j], PDFGenerator.headerFont));
                    cl =  new PdfPCell(celda);
                    cl.setBackgroundColor(color);
                    table.addCell(cl);
                }
            }
        }

        private void crearBloqueoDepartamentalDuenoTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 2;
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if (j==0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                    }
                    else{
                        celda.add(new Paragraph(" ", content));
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }
        }
        
        private void crearHeaderBloqueoDepartamentalLider(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            String label[] = {"Núm.", "Nombre", "N°Candado", "Empresa", "Bloqueo", "Desbloqueo"};
            int columnas = table.getNumberOfColumns();
            int filas =2;

            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                //celda.setAlignment(Element.ALIGN_CENTER);
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                //cl.setFixedHeight(12);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                cl.setVerticalAlignment(Element.ALIGN_BOTTOM);
                //cl.setColspan(3);
                cl.setBorder(Rectangle.TOP| Rectangle. LEFT | Rectangle. RIGHT);
                table.addCell(cl);
            }
        }
        private void crearBloqueoDepartamentalLiderTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 4;
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if (j==0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                    }
                    else{
                        celda.add(new Paragraph(" ", content));
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }
        }

        private void creaBloqueoPersonalTable(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 15;
            for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if (j==0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                    }
                    else{
                        celda.add(new Paragraph(" ", content));
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }
        }

        private void crearObservaciones(PdfPTable table, BaseColor color){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 5;

            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(" ", content));
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
        }
    }
