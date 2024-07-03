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
        this.listaExpedientes = new ListaEnlazada<Expediente>();
        this.expedientes = new ColaExpediente(); 
    }

    private String nombreDependencia(Dependencia dependencia) {
        if (dependencia.getSubTipo() == null) {
            return dependencia.getTipo();
        } else {
            return dependencia.getTipo() + ", " + dependencia.getSubTipo();
        }
    }
    
    private String generarID(Dependencia dependencia) {
        String prefix = dependencia.getID();
        int counter = listaExpedientes.contar() + 1;
        return String.format("%s%010d", prefix, counter);
    }

    public void registrarExpediente(Dependencia dependencia, Expediente expediente) {
        if (expediente.getId() == null) {
            expediente.setId(generarID(dependencia));
        }
        expediente.getTrámite().setFechaHoraInicio(new Date().toString());
        expediente.agregarMovimiento("Expediente registrado en " + nombreDependencia(dependencia));
        expediente.getTrámite().adjuntarDocumento(expediente.getDocumentoReferencia());
        System.out.println("Registrar Expediente (antes)\n" + expedientes.toString());
        listaTrámites.insertar(expediente.getTrámite());
        listaExpedientes.insertar(expediente);
        agregarExpediente(expediente);
        System.out.println("Registrar Expediente (antes)\n" + expedientes.toString());
    }
    
     public void agregarExpediente(Expediente expediente) {
        expedientes.encolar(expediente);
    }

    public void moverExpediente(String expedienteId, Dependencia dependenciaDestino) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        System.out.println("Mover Expediente (antes)\n" + expedientes.toString());
        if (expediente != null) {
            if (!expediente.isFinalizado()) {
                expediente.agregarMovimiento("Se transfirió el trámite de \"" + nombreDependencia(expediente.getDependencia()) + "\" a \"" + nombreDependencia(dependenciaDestino) + "\"");
                expediente.setDependencia(dependenciaDestino);
            } else {
                JOptionPane.showMessageDialog(null, "El expediente \"" + expedienteId + "\" ha sido finalizado y no puede ser movido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Mover Expediente (después)\n" + expedientes.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void agregarDocumento(String expedienteId, String documento) {
        
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        System.out.println("Añadir documento (antes)\n" + expedientes.toString());
        if (expediente != null) { 
            Trámite trámite = expediente.getTrámite();
            trámite.adjuntarDocumento(documento);
            System.out.println("Añadir documento (después)\n" + expedientes.toString());
            expediente.agregarMovimiento(expediente.getDependencia().toString() + ": Se adjuntó \"" + documento + "\"");
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public void finalizarExpediente(String expedienteId) {
        System.out.println("Finalizar Expediente (antes)\n" + expedientes.toString());
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) {
            if (!expediente.isFinalizado()) {
                expediente.getTrámite().setFechaHoraFinalizacion(new Date().toString());
                expediente.agregarMovimiento("Expediente finalizado");
                expediente.setFinalizado(true);
                expedientes.procesarExpediente(expedienteId);
            } else {
                JOptionPane.showMessageDialog(null, "El expediente \"" + expedienteId + "\" ya ha sido finalizado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Finalizar Expediente (después)\n" + expedientes.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Error: El expediente \"" + expedienteId + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public String mostrarSeguimiento(String expedienteId) {
        Expediente expediente = expedientes.buscarExpediente(expedienteId);
        if (expediente != null) {
            return "Seguimiento del expediente " + expedienteId + ":\n" + expediente.mostrarMovimientos();
        } else {
            return "El expediente de trámite \"" + expedienteId + "\" ha finalizado.";
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