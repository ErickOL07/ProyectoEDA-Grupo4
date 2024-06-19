package Trámites._4_Seguimiento;

import TDA.*;
import java.util.Date;

public class Trámite {
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private ListaEnlazada<Movimiento> movimientos;

    public Trámite(ListaEnlazada<Movimiento> movimientos) {
        this.movimientos = movimientos;
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

    public void setMovimientos(ListaEnlazada<Movimiento> movimientos) {
        this.movimientos = movimientos;
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
