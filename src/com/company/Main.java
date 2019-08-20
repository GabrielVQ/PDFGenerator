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
        String nombre = "asdfg";
        //System.out.println("comp"+(nombre.compareTo("asdfg")));
        //personal en general tabla 6, 7 y 8
        ResultSet rs = statement.executeQuery("SELECT worker.worker_names, worker.worker_last_name, worker_log.action, worker_log.timestamp, enterprise.enterprise_name from block_mel_db_dev.worker inner join block_mel_db_dev.worker_log on worker.worker_id=worker_log.worker_id inner join block_mel_db_dev.enterprise on worker.enterprise_id = enterprise.enterprise_id where  worker_log.scheduled_block_id ="+ id+" ;");
        ArrayList<Personal> trabajadores = new ArrayList<Personal>();
        Personal trabajador;
        while (rs.next()) {
            //System.out.println(rs.getString("scheduled_block_name"));
            //if(rs.getString("workernames"))
            trabajador = new Personal();
            String nombretrabajador = rs.getString("worker_names")+ " " +rs.getString("worker_last_name");
            int aux = pyrblo.verficarbloqueo(nombretrabajador, trabajadores);
            if( aux == -1){
                trabajador.setNombre(nombretrabajador);
                //System.out.println("asd"+trabajador.getNombre());
                String partsbloqueo[] = rs.getString("timestamp").split(" ");
                trabajador.setFechabloqueo(partsbloqueo[0]);
                trabajador.setHorabloqueo(partsbloqueo[1]);
                trabajador.setEmpresa(rs.getString("enterprise_name"));
                trabajador.setFirma1("Firmado");
                //System.out.println("bloqueo");
                trabajadores.add(trabajador);
            }
            else{
                String partsdesbloqueo[] = rs.getString("timestamp").split(" ");
                trabajadores.get(aux).setFechadesbloqueo(partsdesbloqueo[0]);
                trabajadores.get(aux).setHoradesbloqueo(partsdesbloqueo[1]);
                trabajadores.get(aux).setFirma2("Firmado");
                //System.out.println("desbloqueo");
                //System.out.println("bsa"+trabajadores.get(0).getNombre());
            }
            i++;
        }
        pyrblo.setPersonal(trabajadores);
        //System.out.println(trabajadores.get(0).getNombre());
        for (int j=0; j<pyrblo.getPersonal().size(); j++) {
            //System.out.println(pyrblo.getPersonal().get(j).getNombre());
        }
        // tabla 1 solictantes
        Solicitante soli ;
        ArrayList<Solicitante> solicitantes = new ArrayList<Solicitante>();
        rs = statement.executeQuery("SELECT r.rol_name, w.worker_id, w.worker_names, w.worker_last_name, w.worker_last_name, e.enterprise_name, sbhw.scheduled_block_id FROM rol r INNER JOIN worker w ON r.rol_id = w.rol_id INNER JOIN enterprise e ON w.enterprise_id = e.enterprise_id INNER JOIN scheduled_block_has_worker sbhw ON sbhw.worker_id = w.worker_id INNER JOIN scheduled_block sb ON sb.scheduled_block_id = sbhw.scheduled_block_id WHERE r.rol_name = 'SUPERVISOR' AND sb.scheduled_block_id="+id+";");
        while (rs.next()){
            soli = new Solicitante();
            soli.setNombre(rs.getString("worker_names") +" "+ rs.getString("worker_last_name"));
            soli.setDisciplina(rs.getString("rol_name"));
            soli.setEmpresa(rs.getString("enterprise_name"));
            soli.setCelular("123456789");
            solicitantes.add(soli);
            //System.out.println(rs.getString("rol_name"));
            rs.next();
        }
        pyrblo.setSolicitantes(solicitantes);
        //tabla 2 equipos, area a bloquear
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
        //tabla 3 trabajo a realizar requerimientos
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

        //if(rs.next()) {
            System.out.println("datos");
            while (rs.next()) {
                req = new Requerimiento();
                req.setNombreTrabajo(rs.getString("BLOQUEO") + " " + rs.getString("DESCRIPCION"));//descripcion o nombre del trabajo
                req.setFechadesde("26/09/2019");//fecha desde
                req.setFechahasta("25/12/2019");//fecha hasta
                reqs.add(req);
                rs.next();
            }
        /*}
        else{
            System.out.println("no datos");
            req = new Requerimiento();
            req.setNombreTrabajo("No hay trabajo");//descripcion o nombre del trabajo
            req.setFechadesde("S/N");//fecha desde
            req.setFechahasta("S/N");//fecha hasta
            reqs.add(req);
            rs.next();
        }*/
        pyrblo.setRequerimientos(reqs);

        /*i=0;
        while (pyrblo.getNombrebloqueodepartamentalpersonal()[i] != null) {
            System.out.println("asd:" + pyrblo.getFechainiciobloqueodepartamentalpersonal()[i]);
            i++;
        }*/
        //tabla 5 energias
        rs = statement.executeQuery("SELECT \n" +
                "\tsbhe.scheduled_block_has_zero_power_test AS ESTADO_ENERGÍA_ZERO, w.worker_names AS NOMBRE_RESPONSABLE, w.worker_last_name AS APELLIDO_RESPONSABLE, e.enterprise_name AS EMPRESA, wl.action AS ESTADO_ENERGÍA_ZERO_EN_WORKER, wl.timestamp FIN_BLOQUEO\n" +
                "FROM    \n" +
                "\tscheduled_block sb\n" +
                "INNER JOIN \n" +
                "\tenterprise e\n" +
                "ON\n" +
                "\tsb.enterprise_id = e.enterprise_id\n" +
                "INNER JOIN \n" +
                "\tworker w\n" +
                "ON\n" +
                "\tw.enterprise_id = e.enterprise_id\n" +
                "INNER JOIN\n" +
                "\tworker_log wl\n" +
                "ON\n" +
                "\twl.worker_id = w.worker_id\n" +
                "INNER JOIN\n" +
                "\tscheduled_block_has_worker sbhw\n" +
                "ON\n" +
                "\tw.worker_id = sbhw.worker_id\n" +
                "INNER JOIN\n" +
                "\tscheduled_block_has_equipment sbhe\n" +
                "ON\n" +
                "\tsbhe.scheduled_block_id = sb.scheduled_block_id\n" +
                "WHERE \n" +
                "\tsbhe.scheduled_block_has_zero_power_test = 'READY' AND sbhw.scheduled_block_id =" +id+" AND sbhw.scheduled_block_has_worker_state = 'LOCK_NON_PLACED' AND wl.action = 'LOCK_NON_PLACED';");

        ArrayList<Energia> energias = new ArrayList<>();
        Energia en;
        while (rs.next()){
            en = new Energia();
            en.setNombre(rs.getString("NOMBRE_RESPONSABLE")+" "+rs.getString("APELLIDO_RESPONSABLE"));//nombre equipo
            en.setEmpresa(rs.getString("EMPRESA"));//area bloqueo
            en.setFirma("Firmado electronicamente");//tag
            en.setValormedido(rs.getString("ESTADO_ENERGÍA_ZERO_EN_WORKER"));
            en.setInstrumento("Instrumento");
            en.setProceder(" ");
            energias.add(en);
            rs.next();
        }
        pyrblo.setEnergias(energias);
        PDFGenerator generatePDFFileIText = new PDFGenerator(pyrblo);
        generatePDFFileIText.createPDF(new File("/home/hsecurity/PDF/ejemplo.pdf"));
        //generatePDFFileIText.createPDF(new File("C:/Users/Gabriel/Desktop/pdfejemplo/ejemplo2.pdf"));
    }
}
