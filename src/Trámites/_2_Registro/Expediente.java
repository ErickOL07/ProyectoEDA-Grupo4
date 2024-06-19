package Trámites._2_Registro;

import java.util.Date;

public class Expediente {
    private int id;
    private int prioridad;
    private Interesado datosInteresado;
    private String asunto;
    private String documentoReferencia;
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private ListaEnlazada<Movimiento> movimientos;

    public Expediente(Interesado datosInteresado, String asunto, String documentoReferencia) {
        this.datosInteresado = datosInteresado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.movimientos = new ListaEnlazada<Movimiento>();
    }

    public int getId() {
        return id;
    }

    public void setid(int id)
    {
        this.id=id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int Prioridad)
        {
            this.prioridad=Prioridad;
        }

    public Interesado getDatosInteresado() {
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
