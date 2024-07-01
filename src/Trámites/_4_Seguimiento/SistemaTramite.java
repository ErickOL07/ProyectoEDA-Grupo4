package Trámites._4_Seguimiento;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._3_FlujoRegistro.*;

import java.util.Date;
import javax.swing.JOptionPane;

public class SistemaTramite {
    public ListaEnlazada<Trámite> listaTrámites;
    public ListaEnlazada<Expediente> listaExpedientes;
    private ListaEnlazada<Dependencia> listaDependencias;
    private ColaExpediente expedientes;

    public SistemaTramite() {
        this.listaTrámites = new ListaEnlazada<Trámite>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
        this.expedientes = new ColaExpediente(); 
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
        expediente.agregarMovimiento("Expediente registrado en " + nombreDependencia(dependencia));
        trámite.adjuntarDocumento(expediente.getDocumentoReferencia());
        listaTrámites.insertar(trámite);
        listaExpedientes.insertar(expediente);
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
            expediente.agregarMovimiento("Se transfirió el trámite de \"" + nombreDependencia(expediente.getDependencia()) + "\" a \"" + nombreDependencia(dependenciaDestino));
            expediente.setDependencia(dependenciaDestino);
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void finalizarExpediente(String expedienteId) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) { 
            Trámite trámite = expediente.getTrámite();
            trámite.setFechaHoraFinalizacion(new Date().toString());
            expediente.agregarMovimiento("Expediente finalizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.expedientes.desencolar();
    }

    public void mostrarSeguimiento(String expedienteId) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) { 
            System.out.println("Seguimiento del expediente " + expedienteId +
                               ":\n" + expediente.mostrarMovimientos());
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
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

    public ListaEnlazada<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public void setListaExpedientes(ListaEnlazada<Expediente> listaExpedientes) {
        this.listaExpedientes = listaExpedientes;
    }
    
    public ColaExpediente getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ColaExpediente expedientes) {
        this.expedientes = expedientes;
    }

}
