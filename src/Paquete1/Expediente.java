/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

/**
 *
 * @author Gianmarco Arrasco
 */
import java.util.Date;

public class Expediente {
    private String id;
    private String prioridad;
    private String datosInteresado;
    private String asunto;
    private String documentoReferencia;
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private ListaEnlazada<Movimiento> movimientos;

    public Expediente(String id, String prioridad, String datosInteresado, String asunto, String documentoReferencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.datosInteresado = datosInteresado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.fechaHoraInicio = "";
        this.fechaHoraFinalizacion = "";
        this.movimientos = new ListaEnlazada<>();
    }

    public String getId() {
        return id;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getDatosInteresado() {
        return datosInteresado;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDocumentoReferencia() {
        return documentoReferencia;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(String fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public ListaEnlazada<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void agregarMovimiento(String descripcion) {
        Movimiento movimiento = new Movimiento(descripcion, new Date().toString());
        movimientos.insertar(movimiento);
    }

    public void mostrarMovimientos() {
        Nodo<Movimiento> current = movimientos.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
