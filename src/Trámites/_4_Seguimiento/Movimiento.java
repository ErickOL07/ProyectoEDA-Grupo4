package Trámites._4_Seguimiento;
/**
 *
 * @author Gianmarco Arrasco
 */
public class Movimiento {
    private String descripcion;
    private String fecha;

    public Movimiento(String descripcion, String fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return fecha + " | " + descripcion + "\n";
    }
}