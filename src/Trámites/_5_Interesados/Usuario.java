package Trámites._5_Interesados;

public abstract class Usuario {
    private String correo;
    private String contraseña;

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
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

}