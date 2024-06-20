package Trámites._3_FlujoRegistro;
import Trámites._3_FlujoRegistro.Trámite;
import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;

import java.util.Date;

public class SistemaTramite {
    private ListaEnlazada<Trámite> listaTrámites;
    private ListaEnlazada<Dependencia> listaDependencias;
    private ColaExpediente expedientes;

    public SistemaTramite() {
        this.listaTrámites = new ListaEnlazada<Trámite>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
    }

    public void registrarExpediente(Dependencia dependencia, Expediente expediente, Trámite trámite) {
        trámite.setFechaHoraInicio(new Date().toString());
        trámite.agregarMovimiento("Expediente registrado en " + dependencia.getTipo());
        listaTrámites.insertar(trámite);
        agregarExpediente(expediente);
        
    }
    
     public void agregarExpediente(Expediente expediente) {
        expedientes.encolar(expediente);
    }

    public Expediente procesarExpediente() {
        return expedientes.desencolar();
    }

    public void moverExpediente(int expedienteId, String dependenciaDestino) {
        Nodo<Trámite> nodoExpediente = buscarExpediente(expedienteId);
        Nodo<Dependencia> nodoDependencia = listaDependencias.buscar(new Dependencia(dependenciaDestino));

        if (nodoExpediente != null && nodoDependencia != null) {
            Expediente expediente = nodoExpediente.getData();
            Dependencia nuevaDependencia = nodoDependencia.getData();
            expediente.agregarMovimiento("Expediente movido a " + nuevaDependencia.getNombre());
            agregarExpediente(expediente);
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
