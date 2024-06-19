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

public class SistemaTramite {
    private ListaEnlazada<Expediente> listaExpedientes;
    private ListaEnlazada<Dependencia> listaDependencias;

    public SistemaTramite() {
        this.listaExpedientes = new ListaEnlazada<>();
        this.listaDependencias = new ListaEnlazada<>();
    }

    public void registrarExpediente(Dependencia dependencia, Expediente expediente) {
        expediente.setFechaHoraInicio(new Date().toString());
        expediente.agregarMovimiento("Expediente registrado en " + dependencia.getNombre());
        listaExpedientes.insertar(expediente);
        dependencia.agregarExpediente(expediente);
    }

    public void moverExpediente(String expedienteId, String dependenciaDestino) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        Nodo<Dependencia> nodoDependencia = listaDependencias.buscar(new Dependencia(dependenciaDestino));

        if (nodoExpediente != null && nodoDependencia != null) {
            Expediente expediente = nodoExpediente.getData();
            Dependencia nuevaDependencia = nodoDependencia.getData();
            expediente.agregarMovimiento("Expediente movido a " + nuevaDependencia.getNombre());
            nuevaDependencia.agregarExpediente(expediente);
        } else {
            System.out.println("Expediente o dependencia no encontrados");
        }
    }

    public void finalizarExpediente(String expedienteId) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Expediente expediente = nodoExpediente.getData();
            expediente.setFechaHoraFinalizacion(new Date().toString());
            expediente.agregarMovimiento("Expediente finalizado");
        }
    }

    public void mostrarSeguimiento(String expedienteId) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Expediente expediente = nodoExpediente.getData();
            System.out.println("Seguimiento del expediente " + expedienteId);
            System.out.println("Inicio: " + expediente.getFechaHoraInicio());
            System.out.println("Finalización: " + expediente.getFechaHoraFinalizacion());
            expediente.mostrarMovimientos();
        }
    }

    public ListaEnlazada<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }
    
    
    
    private Nodo<Expediente> buscarExpediente(String expedienteId) {
        Nodo<Expediente> current = listaExpedientes.getHead();
        while (current != null) {
            if (current.getData().getId().equals(expedienteId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}


