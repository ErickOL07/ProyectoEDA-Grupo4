public class dependencia
{
  private int id;
  private String nombre;
  private String direccion;
  private colas<Expediente> expedientes ;

  public Dependencia(int id, String nombre, String direccion) {
      this.id = id;
      this.nombre = nombre;
      this.direccion = direccion;
     expedientes = new colas<Expediente>();
  }

    public String getNombre() {
        return nombre;
    }
    public String setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public void recibirExpediente(Expediente expediente)
    {
      expedientes.encolar(expediente);  
    }
    public Expediente atenderExpediente()
    {
      return expedientes.desencolar();
    }

}