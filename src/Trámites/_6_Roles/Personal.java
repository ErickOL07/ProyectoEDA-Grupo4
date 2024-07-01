package Trámites._6_Roles;

import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._4_Seguimiento.*;
import Trámites._5_Interesados.*;
import javax.swing.JOptionPane;

public class Personal extends Usuario {
    
    private String Nombre;
    private String Apellido;
    private String DNI;
    private String DependenciaID;

    public Personal(String Nombre, String Apellido, String DNI, String DependenciaID, String correo, String contraseña) {
        super(correo, contraseña);
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.DependenciaID = DependenciaID;
    }

    public void registrarIngresoExpediente(SistemaTramite sistema, Expediente expediente) {
        
        if (expediente.getDependencia().getID().equals(this.DependenciaID)) {
            
            sistema.agregarExpediente(expediente);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error: Carece de permisos para realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Error: Carece de permisos para realizar esta operación.");
        }
        
    }
    
    public void registrarMovimientoExpediente(SistemaTramite sistema, String ID, Dependencia dependenciaDestino) {
        
        if (sistema.getExpedientes().buscarExpediente(ID).getDependencia().getID().equals(this.DependenciaID)) {
            
            sistema.moverExpediente(ID, dependenciaDestino);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error: Carece de permisos para realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Error: Carece de permisos para realizar esta operación.");
        }
        
        
    }
    
    public void registrarFinalizaciónExpediente(SistemaTramite sistema, String ID) {
        
        if (sistema.getExpedientes().buscarExpediente(ID).getDependencia().getID().equals(this.DependenciaID)) {
            
            sistema.finalizarExpediente(ID);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error: Carece de permisos para realizar esta operación.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Error: Carece de permisos para realizar esta operación.");
        }
        
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

    public String getDependenciaID() {
        return DependenciaID;
    }

    public void setDependenciaID(String DependenciaID) {
        this.DependenciaID = DependenciaID;
    }
    
}
