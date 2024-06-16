public class administracion
{
    private int id;
    private String nombre;
    private String contrasena;
    private Rol rol;
    private Usuario siguiente;
    public Usuario(int id, String nombre, String contrasena, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.siguiente = null;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
}

