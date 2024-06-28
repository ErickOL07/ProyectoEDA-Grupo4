package Trámites._4_Seguimiento;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._3_FlujoRegistro.*;

import java.util.Date;

public class SistemaTramite {
    private ListaEnlazada<Trámite> listaTrámites;
    private ListaEnlazada<Dependencia> listaDependencias;
    private ColaExpediente expedientes;

    public SistemaTramite() {
        this.listaTrámites = new ListaEnlazada<Trámite>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
    }

    private String nombreDependencia(Dependencia dependencia) {
        if (dependencia.getSubTipo() == null) {
            return dependencia.getTipo();
        } else {
            return dependencia.getTipo() + ", " + dependencia.getSubTipo();
        }
    }

    public void registrarExpediente(Dependencia dependencia, Expediente expediente, Trámite trámite) {
        trámite.setFechaHoraInicio(new Date().toString());
        expediente.agregarMovimiento(new Date().toString() + " | Expediente registrado en " + nombreDependencia(dependencia));
        listaTrámites.insertar(trámite);
        expediente.setTrámite(trámite);
        agregarExpediente(expediente);
        
    }
    
     public void agregarExpediente(Expediente expediente) {
        expedientes.encolar(expediente);
    }

    public Expediente procesarExpediente() {
        return expedientes.desencolar();
    }

    public void moverExpediente(String expedienteId, Dependencia dependenciaDestino) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) {
            expediente.agregarMovimiento(new Date().toString() + " | Se transfirió el trámite de \"" + nombreDependencia(expediente.getDependencia()) + "\" a \"" + nombreDependencia(dependenciaDestino));
            expediente.setDependencia(dependenciaDestino);
        } else {
            throw new RuntimeException("Error: El expediente \"" + expedienteId + "\" no fue encontrado.");
        }
    }

    public void finalizarExpediente(String expedienteId) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) { 
            Trámite trámite = expediente.getTrámite();
            trámite.setFechaHoraFinalizacion(new Date().toString());
            expediente.agregarMovimiento(new Date().toString() + " | Expediente finalizado");
        } else {
            throw new RuntimeException("Error: El expediente \"" + expedienteId + "\" no fue encontrado.");
        }
    }

    public void mostrarSeguimiento(String expedienteId) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) { 
            Trámite trámite = expediente.getTrámite();
            System.out.println("Seguimiento del expediente " + expedienteId +
                               ":\n" + expediente.mostrarMovimientos());
        } else {
            throw new RuntimeException("Error: El expediente \"" + expedienteId + "\" no fue encontrado.");
        }
    }

    public ListaEnlazada<Trámite> getListaTrámites() {
        return listaTrámites;
    }

    public void setListaTrámites(ListaEnlazada<Trámite> listaTrámites) {
        this.listaTrámites = listaTrámites;
    }

    public ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }

    public void setListaDependencias(ListaEnlazada<Dependencia> listaDependencias) {
        this.listaDependencias = listaDependencias;
    }

    public ColaExpediente getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ColaExpediente expedientes) {
        this.expedientes = expedientes;
    }

}
