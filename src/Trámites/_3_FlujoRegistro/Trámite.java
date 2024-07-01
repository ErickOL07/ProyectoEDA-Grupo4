package Trámites._3_FlujoRegistro;

import TDA.*;

public class Trámite {
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private ListaEnlazada documento;

    public Trámite() {
    }
    
    public void adjuntarDocumento(String documento) {
        
        this.documento.insertar(documento);
        
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public ListaEnlazada getDocumento() {
        return documento;
    }

    public void setDocumento(ListaEnlazada documento) {
        this.documento = documento;
    }

    public String getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(String fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

}
