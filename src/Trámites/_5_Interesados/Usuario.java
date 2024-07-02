package Trámites._5_Interesados;

import TDA.*;
import Trámites._2_Registro.*;
import Trámites._4_Seguimiento.*;
import javax.swing.JOptionPane;

public abstract class Usuario {
    
    private String correo;
    private String contraseña;

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public String getNombreUsuario() {
        return correo;
    }

    public void setNombreUsuario(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    } 
    
    public String observarSeguimiento(SistemaTramite sistema) {
        ListaEnlazada<Expediente> listaOriginal = sistema.getListaExpedientes();
        ListaEnlazada<Expediente> listaCopia = new ListaEnlazada<Expediente>();
        String seguimiento = "";
        
        Nodo<Expediente> ptr = listaOriginal.getHead();
        while (ptr != null) {
            listaCopia.insertar(ptr.getData());
            ptr = ptr.getNext();
        }
        
        boolean existencias = true;
                
        if (!listaCopia.estaVacia()) {
            while (existencias) {
                seguimiento += buscarExpediente(listaCopia).getMovimientos();
                listaCopia.eliminar(buscarExpediente(listaCopia));
            }
        } else {
            return "No existen expedientes de trámites asociados a usted.";
        }
        
        return seguimiento;
    }
    
    public Expediente buscarExpediente(ListaEnlazada listaExpedientes) {
        
        Nodo<Expediente> ptr = listaExpedientes.getHead();
        
        while (ptr != null) {
            if (ptr.getData().getDatosInteresado() == this) {
                return ptr.getData();
            } else {
                ptr = ptr.getNext();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Error: El usuario interesado \"" + this.correo + "\" no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
        
    }

}