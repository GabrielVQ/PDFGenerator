package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.java.swing.plaf.windows.WindowsBorders;

import javax.swing.border.Border;
import java.awt.*;
import java.io.*;

public class PDFGenerator {
        Pyrblo pyrblo;
        // Fonts definitions (Definición de fuentes).
        private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        private static final Font content = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
        private static final Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.WHITE);
        private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
        //Color de tablas
        private static final BaseColor color = new BaseColor(43,69,145);

    public PDFGenerator(Pyrblo pyrblo) {
        this.pyrblo = pyrblo;
    }

    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document(PageSize.LETTER, 1,1,6,2);
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }

            document.open();


            //Ancho tablas
            int ancho = 95;
            //Titulos de tablas

            Paragraph parrafo = new Paragraph("Este permiso debe ser presentado por lo menos con 48 horas de anticipación por el lider de la actividad", smallBold);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            //titulo tabla 1
            PdfPTable label1 = new PdfPTable(1);
            Paragraph celda = new Paragraph(new Paragraph("\n\n1.- Identificación de los solicitantes (solo Supervisores)", smallBold));
            PdfPCell cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label1.setWidthPercentage(ancho);
            label1.addCell(cl);
            //titulo tabla 2
            PdfPTable label2 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n2.- Identificación del Área a bloquear", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label2.setWidthPercentage(ancho);
            label2.addCell(cl);

            PdfPTable label3 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n3.- Identificación de requerimiento", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label3.setWidthPercentage(ancho);
            label3.addCell(cl);

            PdfPTable label4 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n4.- Aprobación", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label4.setWidthPercentage(ancho);
            label4.addCell(cl);

            PdfPTable label5 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n5.- Verificación de Energía Cero", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label5.setWidthPercentage(ancho);
            label5.addCell(cl);

            PdfPTable label6 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n6.- Registro de Bloqueo Departamentales Dueño de Área (primer bloqueo)", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label6.setWidthPercentage(ancho);
            label6.addCell(cl);

            PdfPTable label7 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n7.- Registro de Bloqueo Departamentales Líder de la Actividad", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label7.setWidthPercentage(ancho);
            label7.addCell(cl);

            PdfPTable label8 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n8.- Registro de Bloqueo Personales", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label8.setWidthPercentage(ancho);
            label8.addCell(cl);

            PdfPTable label9 = new PdfPTable(1);
            celda = new Paragraph(new Paragraph("\n9.- Observaciones", smallBold));
            cl = new PdfPCell(celda);
            cl.setHorizontalAlignment(Element.ALIGN_LEFT);
            cl.setBorder(0);
            label9.setWidthPercentage(ancho);
            label9.addCell(cl);




            //Creacion de tablas
            PdfPTable header = new PdfPTable(3);
            header.setWidthPercentage(ancho);
            header.setWidths(new float[] {0.5f,2.5f,0.8f});
            PdfPTable headersolicitantestable = new PdfPTable(4);
            headersolicitantestable.setWidthPercentage(ancho);
            headersolicitantestable.setWidths(new float[] {3f,2f,2f,2f});
            PdfPTable solicitantestable = new PdfPTable(5);
            solicitantestable.setWidthPercentage(ancho);
            solicitantestable.setWidths(new float[] {0.4f,2.6f,2f,2f,2f});
            PdfPTable areatable = new PdfPTable(3);
            areatable.setWidthPercentage(ancho);
            areatable.setWidths(new float[] {3f,2f,4f});
            PdfPTable headerrequerimiento = new PdfPTable(2);
            headerrequerimiento.setWidthPercentage(ancho);
            headerrequerimiento.setWidths(new float[] {5f,4f});
            PdfPTable requerimientotable = new PdfPTable(3);
            requerimientotable.setWidthPercentage(ancho);
            requerimientotable.setWidths(new float[] {5f, 1.5f, 2.5f});
            PdfPTable aprobaciontable = new PdfPTable(5);
            aprobaciontable.setWidthPercentage(ancho);
            aprobaciontable.setWidths(new float[] {3f, 2f, 2f, 1f, 1f});
            PdfPTable energiatable = new PdfPTable(6);
            energiatable.setWidthPercentage(ancho);
            energiatable.setWidths(new float[] {3f, 2f, 1.2f, 1.2f, 0.7f, 0.9f});
            PdfPTable headerbloqueo = new PdfPTable(6);
            headerbloqueo.setWidthPercentage(ancho);
            headerbloqueo.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f, 2f});
            PdfPTable headerbloqueo2 = new PdfPTable(10);
            headerbloqueo2.setWidthPercentage(ancho);
            headerbloqueo2.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable bloquerodepartamentalduenotable = new PdfPTable(10);
            bloquerodepartamentalduenotable.setWidthPercentage(ancho);
            bloquerodepartamentalduenotable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable headerbloqueodepartamentallider = new PdfPTable(6);
            headerbloqueodepartamentallider.setWidthPercentage(ancho);
            headerbloqueodepartamentallider.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f, 2f});
            PdfPTable bloqueodepartamentallidertable = new PdfPTable(10);
            bloqueodepartamentallidertable.setWidthPercentage(ancho);
            bloqueodepartamentallidertable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable bloqueopersonaltable = new PdfPTable(10);
            bloqueopersonaltable.setWidthPercentage(ancho);
            bloqueopersonaltable.setWidths(new float[] {0.4f, 2.6f, 0.7f, 1.3f, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3, 2f/3});
            PdfPTable observaciones = new PdfPTable(1);
            observaciones.setWidthPercentage(ancho);
            //document.add(parrafo1);

            createHeader(header);
            createHeaderApllicants(headersolicitantestable);
            createApllicantsTable(solicitantestable);
            createAreaTable(areatable);
            createHeaderRequeriment(headerrequerimiento);
            createRequerimentTable(requerimientotable);
            createAprovallTable(aprobaciontable);
            createEnergyTable(energiatable);
            createHeaderBlock(headerbloqueo);
            createHeaderBlock2(headerbloqueo2);
            createBloqueoDepartmentalOwnerTable(bloquerodepartamentalduenotable);
            createHeaderBlockDepartmentalLider(headerbloqueodepartamentallider);
            createBlockDepartmentalLiderTable(bloqueodepartamentallidertable);
            createBlockPersonalTable(bloqueopersonaltable);
            createObservations(observaciones);
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
        private void createHeader(PdfPTable table){
            Font title = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
            Font headerFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.WHITE);
            Font subtitle = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.WHITE);
            //celda logo
            Paragraph celda = new Paragraph();

            String url = "src/Resources/Codelco_logo.png";
            Image image;
            try {
                image = Image.getInstance(url);
                image.scalePercent(5,5);// tamaño de la imagen
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
            celda.add(new Paragraph("(Pyrblo)",subtitle));
            cl = new PdfPCell(celda);
            cl.setBackgroundColor(color);
            cl.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
            cl.setHorizontalAlignment(Element.ALIGN_CENTER);
            cl.setVerticalAlignment(Element.ALIGN_CENTER);
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

        private void createHeaderApllicants(PdfPTable table){
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
        private void createApllicantsTable(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int filas = pyrblo.getSolicitantes().size();//asignar despues con valores dinamicos
            int columnas = 5;
            for (int i =0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(Integer.toString(i+1), content));//nombre solicitantes
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getSolicitantes().get(i).getNombre(), content));//nombre solicitantes
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getSolicitantes().get(i).getDisciplina(), content));//nombre solicitantes
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getSolicitantes().get(i).getEmpresa(), content));//nombre solicitantes
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getSolicitantes().get(i).getCelular(), content));//nombre solicitantes
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
            /*for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if(j == 0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                    }
                    else{
                        celda.add(new Paragraph(" ", content));//asignar dinamicamente luego
                    }
                    cl = new PdfPCell(celda);
                    cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cl);
                }
            }*/
        }

        private void createAreaTable(PdfPTable table){
            PDFGenerator.headerFont.setColor(BaseColor.WHITE);
            int filas =pyrblo.getEquipos().size();
            int columnas =3;
            String label[] = {"Equipo o Sistema", "Área de Bloqueo (OIM/DIS/DPM/ETC)", "Tag o Sistema"};
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);

            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEquipos().get(i).getNombreEquipo(), content));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEquipos().get(i).getAreaBloqueo(), content));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEquipos().get(i).getTag(), content));
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cl);
            }
            /*for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    celda.add(new Paragraph(" ", content)); //agregar
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
            }*/
        }
        private void createHeaderRequeriment(PdfPTable table){

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

        private void createRequerimentTable(PdfPTable table){

            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            BaseColor color = new BaseColor(149, 168, 222);
            int columnas = table.getNumberOfColumns();
            int filas = pyrblo.getRequerimientos().size()+1;
            String label[] = {"Desde (Hora/Fecha)","Hasta (Hora/Fecha)"};
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(new Paragraph(pyrblo.getRequerimientos().get(0).getNombreTrabajo(), content)));//nombre trabajo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(new Paragraph(label[i], content)));
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                table.addCell(cl);
                if(i == 0) {
                    celda = new Paragraph();
                    celda.add(new Paragraph(new Paragraph(pyrblo.getRequerimientos().get(0).getFechadesde(), content)));//fecha desde
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
                if (i == 1){
                    celda = new Paragraph();
                    celda.add(new Paragraph(new Paragraph(pyrblo.getRequerimientos().get(0).getFechahasta(), content)));//fecha hasta
                    cl = new PdfPCell(celda);
                    table.addCell(cl);
                }
            }
            /*for (int i = 0; i<filas; i++){
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
            }*/
        }

        private void createAprovallTable(PdfPTable table){
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

        private void createEnergyTable(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            String label[] = {"Nombre del que realiza la Verificación de Energía Cero", "Empresa", "Firma", "Valor medio", "Instrumernto", "Proceder (SI/NO"};
            int columnas = table.getNumberOfColumns();
            int filas = pyrblo.getEnergias().size();//cambiar
            for (int i = 0; i<columnas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(label[i], PDFGenerator.headerFont));
                cl = new PdfPCell(celda);
                cl.setBackgroundColor(color);
                table.addCell(cl);
            }
            for (int i = 0; i<filas; i++) {
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getNombre(), content)); //nombre
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getEmpresa(), content)); //empresa
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getFirma(), content)); //firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getValormedido(), content)); //valor medido
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getInstrumento(), content)); //instrumento
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getEnergias().get(i).getProceder(), content)); //proceder
                cl = new PdfPCell(celda);
                table.addCell(cl);

            }
        }

        private void createHeaderBlock(PdfPTable table){
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

        private void createHeaderBlock2(PdfPTable table){
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

        private void createBloqueoDepartmentalOwnerTable(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            Border b1 = new WindowsBorders.DashedBorder(Color.BLACK, 3);
            int filas = 1;//!!!!OJO aca cambiar cuando se defina el lider
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(Integer.toString(i+1), content));//numeracion
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getNombre(), content));//nombre personal
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph("N/A", content));//candado
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getEmpresa(), content));//empresa
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechabloqueo(), content));//fecha inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHorabloqueo(), content));//hora inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma1(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechadesbloqueo(), content));//fecha desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHoradesbloqueo(), content));//hora desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma2(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
            /*for (int i = 0; i<filas; i++){
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
            }*/
        }
        
        private void createHeaderBlockDepartmentalLider(PdfPTable table){
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

        private void createBlockDepartmentalLiderTable(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 1;//!!!!OJO aca cambiar cuando se defina el lider
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(Integer.toString(i+1), content));//numeracion
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getNombre(), content));//nombre personal
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph("N/A", content));//candado
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getEmpresa(), content));//empresa
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechabloqueo(), content));//fecha inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHorabloqueo(), content));//hora inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma1(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechadesbloqueo(), content));//fecha desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHoradesbloqueo(), content));//hora desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma2(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
            /*for (int i = 0; i<filas; i++){
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
            }*/
        }

        private void createBlockPersonalTable(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = pyrblo.getPersonal().size();
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(Integer.toString(i+1), content));//numeracion
                cl = new PdfPCell(celda);
                cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getNombre(), content));//nombre personal
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph("N/A", content));//candado
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getEmpresa(), content));//empresa
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechabloqueo(), content));//fecha inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHorabloqueo(), content));//hora inicio bloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma1(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFechadesbloqueo(), content));//fecha desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getHoradesbloqueo(), content));//hora desbloqueo
                cl = new PdfPCell(celda);
                table.addCell(cl);
                celda = new Paragraph();
                celda.add(new Paragraph(pyrblo.getPersonal().get(i).getFirma2(), content));//firma
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
            /*for (int i = 0; i<filas; i++){
                for (int j = 0; j<columnas; j++){
                    celda = new Paragraph();
                    if (j==0){
                        celda.add(new Paragraph(Integer.toString(i+1), content));
                        cl = new PdfPCell(celda);
                        cl.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cl);

                    }
                    else{
                        celda = new Paragraph();
                       // celda.add(new Paragraph(pyrblo.getNombrebloqueodepartamentalpersonal()[i], content));//nombre personal
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        celda.add(new Paragraph("N/A", content));//candado
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        //celda.add(new Paragraph(pyrblo.getPersonal()[i].getEmpresa(), content));//empresa
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        //celda.add(new Paragraph(pyrblo.getFechainiciobloqueodepartamentalpersonal()[i], content));//fecha inicio bloqueo
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        //celda.add(new Paragraph(pyrblo.getHorainiciobloqueodepartamentalpersonal()[i], content));//hora inicio bloqueo
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        celda.add(new Paragraph(" ", content));//firma
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        celda.add(new Paragraph(" ", content));//fecha desbloqueo
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        celda.add(new Paragraph(" ", content));//hora desbloqueo
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        celda = new Paragraph();
                        celda.add(new Paragraph(" ", content));//firma
                        cl = new PdfPCell(celda);
                        table.addCell(cl);
                        j=10;

                    }
                }
            }*/
        }

        private void createObservations(PdfPTable table){
            Paragraph celda = new Paragraph();
            PdfPCell cl = new PdfPCell(celda);
            int columnas =  table.getNumberOfColumns();
            int filas = 6;
            for (int i = 0; i<filas; i++){
                celda = new Paragraph();
                celda.add(new Paragraph(" ", content));
                cl = new PdfPCell(celda);
                table.addCell(cl);
            }
        }
    }