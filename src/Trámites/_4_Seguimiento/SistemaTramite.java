package Trámites._4_Seguimiento;
import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;

import java.util.Date;

public class SistemaTramite {
    private ListaEnlazada<Trámite> listaExpedientes;
    private ListaEnlazada<Dependencia> listaDependencias;

    public SistemaTramite() {
        this.listaExpedientes = new ListaEnlazada<Trámite>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
    }

    public void registrarExpediente(Dependencia dependencia, Trámite trámite) {
        trámite.setFechaHoraInicio(new Date().toString());
        trámite.agregarMovimiento("Expediente registrado en " + dependencia.getTipo());
        listaExpedientes.insertar(trámite);
        trámite.agregarExpediente(trámite);
    }

    public void moverExpediente(int expedienteId, String dependenciaDestino) {
        Nodo<Trámite> nodoExpediente = buscarExpediente(expedienteId);
        Nodo<Dependencia> nodoDependencia = listaDependencias.buscar(new Dependencia(dependenciaDestino));

        if (nodoExpediente != null && nodoDependencia != null) {
            Trámite expediente = nodoExpediente.getData();
            Dependencia nuevaDependencia = nodoDependencia.getData();
            expediente.agregarMovimiento("Expediente movido a " + nuevaDependencia.getNombre());
            nuevaDependencia.agregarExpediente(expediente);
        } else {
            System.out.println("Expediente o dependencia no encontrados");
        }
    }

    public void finalizarExpediente(int expedienteId) {
        Nodo<Trámite> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Trámite expediente = nodoExpediente.getData();
            expediente.setFechaHoraFinalizacion(new Date().toString());
            expediente.agregarMovimiento("Expediente finalizado");
        }
    }

    public void mostrarSeguimiento(int expedienteId) {
        Nodo<Trámite> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Trámite expediente = nodoExpediente.getData();
            System.out.println("Seguimiento del expediente " + expedienteId);
            System.out.println("Inicio: " + expediente.getFechaHoraInicio());
            System.out.println("Finalización: " + expediente.getFechaHoraFinalizacion());
            expediente.mostrarMovimientos();
        }
    }

    public ListaEnlazada<Trámite> getListaExpedientes() {
        return listaExpedientes;
    }

    public ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }

    private Nodo<Trámite> buscarExpediente(int expedienteId) {
        Nodo<Trámite> current = listaExpedientes.getHead();
        while (current != null) {
            if (current.getData().getId()==expedienteId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
