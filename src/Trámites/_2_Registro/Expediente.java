package Trámites._2_Registro;

import Trámites._5_Interesados.Interesado;
import Trámites._1_Inicio.*;
import java.text.DecimalFormat;
import java.util.Date;

public class Expediente {
    private Dependencia dependencia;
    private String id;
    private boolean prioridad;
    private int orden;
    private Interesado datosInteresado;
    private String asunto;
    private String documentoReferencia;

    public Expediente(Dependencia dependencia, boolean prioridad, Interesado datosInteresado, String asunto, String documentoReferencia) {
        this.dependencia = dependencia;
        this.id = id;
        this.prioridad = prioridad;
        this.orden = orden;
        this.datosInteresado = datosInteresado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Interesado getDatosInteresado() {
        return datosInteresado;
    }

    public void setDatosInteresado(Interesado datosInteresado) {
        this.datosInteresado = datosInteresado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocumentoReferencia() {
        return documentoReferencia;
    }

    public void setDocumentoReferencia(String documentoReferencia) {
        this.documentoReferencia = documentoReferencia;
    }
    
    public void ID(int num) {
        DecimalFormat df = new DecimalFormat("0000000000");
        
        this.id = this.dependencia.getID() + df.format(num);
        
    }
    
}
