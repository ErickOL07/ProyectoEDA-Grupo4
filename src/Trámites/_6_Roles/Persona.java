package Trámites._6_Roles;

import TDA.ListaEnlazada;
import TDA.Nodo;
import Trámites._2_Registro.Expediente;
import Trámites._4_Seguimiento.SistemaTramite;
import Trámites._5_Interesados.*;

public class Persona extends Usuario {
    
    private String Nombre;
    private String Apellido;
    private String DNI;

    public Persona(String Nombre, String Apellido, String DNI, String correo, String contraseña) {
        super(correo, contraseña);
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
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
                seguimiento += buscarExpediente(this, listaCopia).getMovimientos();
                listaCopia.eliminar(buscarExpediente(this, listaCopia));
            }
        } else {
            return "No existen expedientes de trámites asociados a su institución.";
        }
        
        return seguimiento;
    }
    
    public Expediente buscarExpediente(Usuario interesado, ListaEnlazada listaExpedientes) {
        
        Nodo<Expediente> ptr = listaExpedientes.getHead();
        
        while (ptr != null) {
            if (ptr.getData().getDatosInteresado() == interesado) {
                return ptr.getData();
            } else {
                ptr = ptr.getNext();
            }
        }
        
        throw new RuntimeException("Error: El usuario interesado \"" + interesado + "\" no fue encontrado.");
        
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    @Override
    public String toString() {
        
        return this.Apellido + ", " + this.Nombre + " (" + this.DNI + ")";
        
    }
    
}
