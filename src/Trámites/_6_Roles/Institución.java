package Trámites._6_Roles;

import Trámites._5_Interesados.*;

public class Institución extends Usuario {

    private String Nombre;

    public Institución(String Nombre, String correo, String contraseña) {
        super(correo, contraseña);
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    @Override
    public String toString() {
        
        return this.Nombre;
        
    }

}