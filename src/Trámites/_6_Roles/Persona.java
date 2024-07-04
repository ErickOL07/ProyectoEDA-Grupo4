package Trámites._6_Roles;

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
    
    @Override
    public String verInfo() {
        
        return this.Apellido + ", " + this.Nombre + " (DNI " + this.DNI + ")\nCorreo: "
                + this.getCorreo();
        
    }
    
}