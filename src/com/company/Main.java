package com.company;

import PDF.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Pyrblo pyrblo = new Pyrblo();

        //Connection con = DriverManager.getConnection("jdbc:mysql://oficina.comercialpau.cl:3306/block_mel_db_dev","gvenegas","Cpau2019!!");
        Connection con = DriverManager.getConnection("jdbc:mysql://comercialpau.no-ip.org:3306/block_mel_db_dev","gvenegas","Cpau2019!!");
        Statement statement = con.createStatement();
        int id = 2, i=0;
        /*String nombrepersonal[] = new String[50];
        String empresapersonal[] = new String[50];
        String horabloqueo[] = new String[50];
        String fechabloqueo[] = new String[50];
        String horadesbloqueo[] = new String[50];
        String fechadesbloqueo[] = new String[50];*/

        //personal en general tabla 6, 7 y 8
        ResultSet rs = statement.executeQuery("SELECT worker.worker_names, worker.worker_last_name, worker_log.action, worker_log.timestamp, enterprise.enterprise_name from block_mel_db_dev.worker inner join block_mel_db_dev.worker_log on worker.worker_id=worker_log.worker_id inner join block_mel_db_dev.enterprise on worker.enterprise_id = enterprise.enterprise_id where  worker_log.scheduled_block_id ="+ id+" ;");
        ArrayList<Personal> trabajadores = new ArrayList<Personal>();
        Personal trabajador;
        while (rs.next()) {
            //System.out.println(rs.getString("scheduled_block_name"));
            trabajador = new Personal();
            trabajador.setNombre(rs.getString("worker_names")+ " " +rs.getString("worker_last_name")) ;
            //System.out.println("asd"+trabajador.getNombre());
            String partsbloqueo[] = rs.getString("timestamp").split(" ");
            trabajador.setFechabloqueo(partsbloqueo[0]);
            trabajador.setHorabloqueo(partsbloqueo[1]);
            trabajador.setEmpresa(rs.getString("enterprise_name"));
            //System.out.println("bloqueo");
            rs.next();
            String partsdesbloqueo[] = rs.getString("timestamp").split(" ");
            trabajador.setFechadesbloqueo(partsdesbloqueo[0]);
            trabajador.setHoradesbloqueo(partsdesbloqueo[1]);
            //System.out.println("desbloqueo");
            trabajadores.add(trabajador);
           // System.out.println("bsa"+trabajadores.get(0).getNombre());
            i++;
        }
        pyrblo.setPersonal(trabajadores);
        //System.out.println(trabajadores.get(0).getNombre());
        for (int j=0; j<pyrblo.getPersonal().size(); j++) {
            //System.out.println(pyrblo.getPersonal().get(j).getNombre());
        }
        //solictantes
        Solicitantes soli ;
        ArrayList<Solicitantes> solicitantes = new ArrayList<Solicitantes>();
        rs = statement.executeQuery("SELECT r.rol_name, w.worker_id, w.worker_names, w.worker_last_name, w.worker_last_name, e.enterprise_name, sbhw.scheduled_block_id FROM rol r INNER JOIN worker w ON r.rol_id = w.rol_id INNER JOIN enterprise e ON w.enterprise_id = e.enterprise_id INNER JOIN scheduled_block_has_worker sbhw ON sbhw.worker_id = w.worker_id INNER JOIN scheduled_block sb ON sb.scheduled_block_id = sbhw.scheduled_block_id WHERE r.rol_name = 'SUPERVISOR' AND sb.scheduled_block_id="+id+";");
        while (rs.next()){
            soli = new Solicitantes();
            soli.setNombre(rs.getString("worker_names") +" "+ rs.getString("worker_last_name"));
            soli.setDisciplina(rs.getString("rol_name"));
            soli.setEmpresa(rs.getString("enterprise_name"));
            soli.setCelular("123456789");
            solicitantes.add(soli);
            //System.out.println(rs.getString("rol_name"));
            rs.next();
        }
        pyrblo.setSolicitantes(solicitantes);
        //equipos, area a bloquear
        rs = statement.executeQuery("SELECT \n" +
                "\teq.equipment_name AS EQUIPO, sbhe.scheduled_block_id AS ID_BLOQUEO\n" +
                "FROM \n" +
                "\tequipment eq\n" +
                "INNER JOIN\n" +
                "\tscheduled_block_has_equipment sbhe\n" +
                "ON\n" +
                "\teq.equipment_id = sbhe.equipment_id\n" +
                "WHERE\n" +
                "\tsbhe.scheduled_block_id ="+id+";");
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo equipo;
        while (rs.next()){
            equipo = new Equipo();
            equipo.setNombreEquipo(rs.getString("EQUIPO"));//nombre equipo
            equipo.setAreaBloqueo("Area bloqueo 1");//area bloqueo
            equipo.setTag("tag");//tag
            equipos.add(equipo);
            rs.next();
        }
        pyrblo.setEquipos(equipos);

        Requerimiento req = new Requerimiento();
        ArrayList<Requerimiento> reqs = new ArrayList<>();
        rs = statement.executeQuery("SELECT \n" +
                "\tsbt.scheduled_block_type_name AS BLOQUEO, sbt.scheduled_block_type_description AS DESCRIPCION, sb.scheduled_block_id AS ID\n" +
                "FROM \n" +
                "\tscheduled_block_type sbt\n" +
                "INNER JOIN\n" +
                "\tscheduled_block sb\n" +
                "ON\n" +
                "\tsbt.scheduled_block_type_id = sb.scheduled_block_type_id\n" +
                "WHERE\n" +
                "\tsb.scheduled_block_id ="+id+";");

        while (rs.next()){
            req = new Requerimiento();
            req.setNombreTrabajo(rs.getString("BLOQUEO")+" "+rs.getString("DESCRIPCION") );//descripcion o nombre del trabajo
            req.setFechadesde("26/09/2019");//fecha desde
            req.setFechahasta("25/12/2019");//fecha hasta
            reqs.add(req);
            rs.next();
        }

        pyrblo.setRequerimiento(reqs);

        /*i=0;
        while (pyrblo.getNombrebloqueodepartamentalpersonal()[i] != null) {
            System.out.println("asd:" + pyrblo.getFechainiciobloqueodepartamentalpersonal()[i]);
            i++;
        }*/

        PDFGenerator generatePDFFileIText = new PDFGenerator(pyrblo);
        generatePDFFileIText.createPDF(new File("/home/hsecurity/PDF/ejemplo.pdf"));
        //generatePDFFileIText.createPDF(new File("C:/Users/Gabriel/Desktop/pdfejemplo/ejemplo2.pdf"));
    }
}
