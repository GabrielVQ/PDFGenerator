package PDF;

import java.util.ArrayList;

public class Pyrblo {

    private ArrayList<Personal> owner;
    private ArrayList<Personal> lider;
    private ArrayList<Personal> personal;
    private ArrayList<Solicitante> solicitantes;
    private ArrayList<Equipo> equipos;
    private ArrayList<Requerimiento> requerimientos;
    private ArrayList<Energia> energias;

    public ArrayList<Energia> getEnergias() {
        return energias;
    }

    public void setEnergias(ArrayList<Energia> energias) {
        this.energias = energias;
    }

    public int verficarbloqueo(String nombre, ArrayList<Personal> personal){
        for (int i =0; i<personal.size();i++){
            if(nombre.compareTo(personal.get(i).getNombre()) == 0){
                if(personal.get(i).getFechadesbloqueo() == null){
                    return i;
                }
            }
        }
            return -1;
    }

    public ArrayList<Requerimiento> getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(ArrayList<Requerimiento> requerimientos) {
        this.requerimientos = requerimientos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Personal> getOwner() {
        return owner;
    }

    public void setOwner(ArrayList<Personal> owner) {
        this.owner = owner;
    }

    public ArrayList<Personal> getLider() {
        return lider;
    }

    public void setLider(ArrayList<Personal> lider) {
        this.lider = lider;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }

    public ArrayList<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(ArrayList<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }
/*private String liderActividad[];
    private String disciplina[];
    private String empresa[];
    private String celular[];
    private String equipo[];
    private String areabloqueo;
    private String tag[];
    private String trabajo[];
    private String duenoarea;
    private String fechadesdesolicitud;
    private String fechahastasolicitud;
    private String fechaenviosolicitud;
    private String aprobacion;
    private String fechaaprobacion;
    private String verificacionenergiaceronombre[];
    private String empresaenergiacero[];
    private String valormedido[];
    private String instrumento[];
    private String nombrebloqueodepartamentaldueno[];
    private String empresabloqueodepartamentaldueno[];
    private String fechainiciobloqueodepartamentaldueno;
    private String horainiciobloqueodepartamentaldueno;
    private String fechafindesbloqueodepartamentaldueno;
    private String horafindesbloqueodepartamentaldueno;
    private String nombrebloqueodepartamentallider[];
    private String empresabloqueodepartamentallider[];
    private String fechainiciobloqueodepartamentallider;
    private String horainiciobloqueodepartamentallider;
    private String fechafindesbloqueodepartamentallider;
    private String horafindesbloqueodepartamentallider;
    private String nombrebloqueodepartamentalpersonal[];
    private String empresabloqueodepartamentalpersonal[];
    private String fechainiciobloqueodepartamentalpersonal[];
    private String horainiciobloqueodepartamentalpersonal[];
    private String fechafindesbloqueodepartamentalpersonal[];
    private String horafindesbloqueodepartamentalpersonal[];





    public String[] getLiderActividad() {
        return liderActividad;
    }

    public void setLiderActividad(String[] liderActividad) {
        this.liderActividad = liderActividad;
    }

    public String[] getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String[] disciplina) {
        this.disciplina = disciplina;
    }

    public String[] getCelular() {
        return celular;
    }

    public void setCelular(String[] celular) {
        this.celular = celular;
    }

    public String[] getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String[] empresa) {
        this.empresa = empresa;
    }

    public String[] getEquipo() {
        return equipo;
    }

    public void setEquipo(String[] equipo) {
        this.equipo = equipo;
    }

    public String getAreabloqueo() {
        return areabloqueo;
    }

    public void setAreabloqueo(String areabloqueo) {
        this.areabloqueo = areabloqueo;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public String[] getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String[] trabajo) {
        this.trabajo = trabajo;
    }

    public String getDuenoarea() {
        return duenoarea;
    }

    public void setDuenoarea(String duenoarea) {
        this.duenoarea = duenoarea;
    }

    public String getFechadesdesolicitud() {
        return fechadesdesolicitud;
    }

    public void setFechadesdesolicitud(String fechadesdesolicitud) {
        this.fechadesdesolicitud = fechadesdesolicitud;
    }

    public String getFechahastasolicitud() {
        return fechahastasolicitud;
    }

    public void setFechahastasolicitud(String fechahastasolicitud) {
        this.fechahastasolicitud = fechahastasolicitud;
    }

    public String getFechaenviosolicitud() {
        return fechaenviosolicitud;
    }

    public void setFechaenviosolicitud(String fechaenviosolicitud) {
        this.fechaenviosolicitud = fechaenviosolicitud;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(String fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public String[] getVerificacionenergiaceronombre() {
        return verificacionenergiaceronombre;
    }

    public void setVerificacionenergiaceronombre(String[] verificacionenergiaceronombre) {
        this.verificacionenergiaceronombre = verificacionenergiaceronombre;
    }

    public String[] getEmpresaenergiacero() {
        return empresaenergiacero;
    }

    public void setEmpresaenergiacero(String[] empresaenergiacero) {
        this.empresaenergiacero = empresaenergiacero;
    }

    public String[] getValormedido() {
        return valormedido;
    }

    public void setValormedido(String[] valormedido) {
        this.valormedido = valormedido;
    }

    public String[] getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String[] instrumento) {
        this.instrumento = instrumento;
    }

    public String[] getNombrebloqueodepartamentaldueno() {
        return nombrebloqueodepartamentaldueno;
    }

    public void setNombrebloqueodepartamentaldueno(String[] nombrebloqueodepartamentaldueno) {
        this.nombrebloqueodepartamentaldueno = nombrebloqueodepartamentaldueno;
    }

    public String[] getEmpresabloqueodepartamentaldueno() {
        return empresabloqueodepartamentaldueno;
    }

    public void setEmpresabloqueodepartamentaldueno(String[] empresabloqueodepartamentaldueno) {
        this.empresabloqueodepartamentaldueno = empresabloqueodepartamentaldueno;
    }

    public String getFechainiciobloqueodepartamentaldueno() {
        return fechainiciobloqueodepartamentaldueno;
    }

    public void setFechainiciobloqueodepartamentaldueno(String fechainiciobloqueodepartamentaldueno) {
        this.fechainiciobloqueodepartamentaldueno = fechainiciobloqueodepartamentaldueno;
    }

    public String getHorainiciobloqueodepartamentaldueno() {
        return horainiciobloqueodepartamentaldueno;
    }

    public void setHorainiciobloqueodepartamentaldueno(String horainiciobloqueodepartamentaldueno) {
        this.horainiciobloqueodepartamentaldueno = horainiciobloqueodepartamentaldueno;
    }

    public String getFechafindesbloqueodepartamentaldueno() {
        return fechafindesbloqueodepartamentaldueno;
    }

    public void setFechafindesbloqueodepartamentaldueno(String fechafindesbloqueodepartamentaldueno) {
        this.fechafindesbloqueodepartamentaldueno = fechafindesbloqueodepartamentaldueno;
    }

    public String getHorafindesbloqueodepartamentaldueno() {
        return horafindesbloqueodepartamentaldueno;
    }

    public void setHorafindesbloqueodepartamentaldueno(String horafindesbloqueodepartamentaldueno) {
        this.horafindesbloqueodepartamentaldueno = horafindesbloqueodepartamentaldueno;
    }

    public String[] getNombrebloqueodepartamentallider() {
        return nombrebloqueodepartamentallider;
    }

    public void setNombrebloqueodepartamentallider(String[] nombrebloqueodepartamentallider) {
        this.nombrebloqueodepartamentallider = nombrebloqueodepartamentallider;
    }

    public String[] getEmpresabloqueodepartamentallider() {
        return empresabloqueodepartamentallider;
    }

    public void setEmpresabloqueodepartamentallider(String[] empresabloqueodepartamentallider) {
        this.empresabloqueodepartamentallider = empresabloqueodepartamentallider;
    }

    public String getFechainiciobloqueodepartamentallider() {
        return fechainiciobloqueodepartamentallider;
    }

    public void setFechainiciobloqueodepartamentallider(String fechainiciobloqueodepartamentallider) {
        this.fechainiciobloqueodepartamentallider = fechainiciobloqueodepartamentallider;
    }

    public String getHorainiciobloqueodepartamentallider() {
        return horainiciobloqueodepartamentallider;
    }

    public void setHorainiciobloqueodepartamentallider(String horainiciobloqueodepartamentallider) {
        this.horainiciobloqueodepartamentallider = horainiciobloqueodepartamentallider;
    }

    public String getFechafindesbloqueodepartamentallider() {
        return fechafindesbloqueodepartamentallider;
    }

    public void setFechafindesbloqueodepartamentallider(String fechafindesbloqueodepartamentallider) {
        this.fechafindesbloqueodepartamentallider = fechafindesbloqueodepartamentallider;
    }

    public String getHorafindesbloqueodepartamentallider() {
        return horafindesbloqueodepartamentallider;
    }

    public void setHorafindesbloqueodepartamentallider(String horafindesbloqueodepartamentallider) {
        this.horafindesbloqueodepartamentallider = horafindesbloqueodepartamentallider;
    }

    public String[] getNombrebloqueodepartamentalpersonal() {
        return nombrebloqueodepartamentalpersonal;
    }

    public void setNombrebloqueodepartamentalpersonal(String[] nombrebloqueodepartamentalpersonal) {
        this.nombrebloqueodepartamentalpersonal = nombrebloqueodepartamentalpersonal;
    }

    public String[] getEmpresabloqueodepartamentalpersonal() {
        return empresabloqueodepartamentalpersonal;
    }

    public void setEmpresabloqueodepartamentalpersonal(String[] empresabloqueodepartamentalpersonal) {
        this.empresabloqueodepartamentalpersonal = empresabloqueodepartamentalpersonal;
    }

    public String[] getFechainiciobloqueodepartamentalpersonal() {
        return fechainiciobloqueodepartamentalpersonal;
    }

    public void setFechainiciobloqueodepartamentalpersonal(String[] fechainiciobloqueodepartamentalpersonal) {
        this.fechainiciobloqueodepartamentalpersonal = fechainiciobloqueodepartamentalpersonal;
    }

    public String[] getHorainiciobloqueodepartamentalpersonal() {
        return horainiciobloqueodepartamentalpersonal;
    }

    public void setHorainiciobloqueodepartamentalpersonal(String[] horainiciobloqueodepartamentalpersonal) {
        this.horainiciobloqueodepartamentalpersonal = horainiciobloqueodepartamentalpersonal;
    }

    public String[] getFechafindesbloqueodepartamentalpersonal() {
        return fechafindesbloqueodepartamentalpersonal;
    }

    public void setFechafindesbloqueodepartamentalpersonal(String[] fechafindesbloqueodepartamentalpersonal) {
        this.fechafindesbloqueodepartamentalpersonal = fechafindesbloqueodepartamentalpersonal;
    }

    public String[] getHorafindesbloqueodepartamentalpersonal() {
        return horafindesbloqueodepartamentalpersonal;
    }

    public void setHorafindesbloqueodepartamentalpersonal(String[] horafindesbloqueodepartamentalpersonal) {
        this.horafindesbloqueodepartamentalpersonal = horafindesbloqueodepartamentalpersonal;
    }*/
}
