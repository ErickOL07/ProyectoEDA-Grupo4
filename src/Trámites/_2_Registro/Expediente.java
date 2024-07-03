package Trámites._2_Registro;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._3_FlujoRegistro.*;
import Trámites._4_Seguimiento.Movimiento;
import Trámites._5_Interesados.Usuario;
import java.text.DecimalFormat;
import java.util.Date;

public class Expediente {
    private Dependencia dependencia;
    private String id;
    private boolean prioridad;
    private int orden;
    private Usuario datosInteresado;
    private String asunto;
    private String documentoReferencia;
    private Trámite trámite;
    private ListaEnlazada<Movimiento> movimientos;
    private boolean finalizado;

    public Expediente(Dependencia dependencia, boolean prioridad, Usuario datosInteresado, String asunto, String documentoReferencia) {
        this.dependencia = dependencia;
        this.prioridad = prioridad;
        this.datosInteresado = datosInteresado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.movimientos = new ListaEnlazada<>();
        this.trámite = new Trámite();
        this.finalizado = false;
        }

    public ListaEnlazada<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ListaEnlazada<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    public void agregarMovimiento(String descripcion) {
        Movimiento movimiento = new Movimiento(descripcion, new Date().toString());
        movimientos.insertar(movimiento);
    }

    public String mostrarMovimientos() {
        Nodo<Movimiento> current = movimientos.getHead();
        String movs = "";
        while (current != null) {
            movs += current.getData();
            current = current.getNext();
        }
        return movs;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Trámite getTrámite() {
        return trámite;
    }

    public void setTrámite(Trámite trámite) {
        this.trámite = trámite;
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

    public Usuario getDatosInteresado() {
        return datosInteresado;
    }

    public void setDatosInteresado(Usuario datosInteresado) {
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
    
    
    @Override
    public String toString() {
        return "Expediente{" +
                "id='" + id + '\'' +
                ", prioridad=" + prioridad +
                ", asunto='" + asunto + '\'' +
                ", dependencia=" + dependencia +
                ", datosInteresado=" + datosInteresado +
                ", documentoReferencia='" + documentoReferencia + '\'' +
                '}';
    }
        
}