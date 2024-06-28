package Trámites._3_FlujoRegistro;

public class Trámite {
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private String[] documento;

    public Trámite() {
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String[] getDocumento() {
        return documento;
    }

    public void setDocumento(String[] documento) {
        this.documento = documento;
    } 

    public String getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(String fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

}
