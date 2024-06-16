package _2_RegistroExpedientes;

public class Interesado
{
   private String nombre;
   private String tipo;
   private String usuario;
   public Interesado(String nombre, String tipo, String usuario) 
    {
     this.nombre = nombre;
     this.tipo = tipo;
     this.usuario = usuario;
   }
   public String getNombre() 
   {
     return nombre;
   }
    public void setNombre(String nombre) 
    {
     this.nombre = nombre;
    }
    public String getTipo()
    {
      return tipo;
    }
    public void setTipo(String tipo)
    {
      this.tipo = tipo;  
    }
    public String getUsuario()
    {
     return usuario; 
    }
    public void setUsuario(String usuario)
    {
     this.usuario = usuario;
    }
}