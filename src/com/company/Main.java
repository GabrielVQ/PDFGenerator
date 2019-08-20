package com.company;

import PDF.PDFGenerator;
import PDF.Pyrblo;

import java.io.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Pyrblo pyrblo = new Pyrblo();

        Connection con = DriverManager.getConnection("jdbc:mysql://oficina.comercialpau.cl:3306/block_mel_db_dev","gvenegas","Cpau2019!!");
        Statement statement = con.createStatement();
        int id = 2, i=0;
        String nombrepersonal[] = new String[50];
        String empresapersonal[] = new String[50];
        String horabloqueo[] = new String[50];
        String fechabloqueo[] = new String[50];
        String horadesbloqueo[] = new String[50];
        String fechadesbloqueo[] = new String[50];


        ResultSet rs = statement.executeQuery("SELECT worker.worker_names, worker.worker_last_name, worker_log.action, worker_log.timestamp from block_mel_db_dev.worker inner join block_mel_db_dev.worker_log on worker.worker_id=worker_log.worker_id where worker.rol_id = 4 and worker_log.scheduled_block_id ="+ id+" ;");

        while (rs.next()) {
            //System.out.println(rs.getString("scheduled_block_name"));
            nombrepersonal[i] = rs.getString("worker_names")+ " " +rs.getString("worker_last_name");
            String parts[] = rs.getString("timestamp").split(" ");
            fechabloqueo[i]= parts[0];
            horabloqueo[i] = parts[1];
            i++;
        }

        pyrblo.setNombrebloqueodepartamentalpersonal(nombrepersonal);
        pyrblo.setFechainiciobloqueodepartamentalpersonal(fechabloqueo);
        pyrblo.setHorainiciobloqueodepartamentalpersonal(horabloqueo);
        i=0;
        while (pyrblo.getNombrebloqueodepartamentalpersonal()[i] != null) {
            System.out.println("asd:" + pyrblo.getFechainiciobloqueodepartamentalpersonal()[i]);
            i++;
        }
        PDFGenerator generatePDFFileIText = new PDFGenerator(pyrblo);
        //generatePDFFileIText.createPDF(new File("/home/hsecurity/PDF/ejemplo.pdf"));
        generatePDFFileIText.createPDF(new File("C:/Users/Gabriel/Desktop/pdfejemplo/ejemplo2.pdf"));
    }
}
