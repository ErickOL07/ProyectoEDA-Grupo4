package Trámites._2_Registro;

public class Dependencia2 {
    private String nombre;
    private ColaExpediente expedientes;

    public Dependencia2(String nombre) {
        this.nombre = nombre;
        this.expedientes = new ColaExpediente();
    }

    public String getNombre() {
        return nombre;
    }

    public ColaExpediente getExpedientes() {
        return expedientes;
    }

    public void agregarExpediente(Expediente expediente) {
        expedientes.encolar(expediente);
    }

    public Expediente procesarExpediente() {
        return expedientes.desencolar();
    }
}


