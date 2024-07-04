package Trámites._1_Inicio;

public class Dependencia {

    private String nombre, subTipo, ID;

    public Dependencia(String tipo, String subTipo, String baseID) {
        this.nombre = tipo;
        this.subTipo = subTipo;
        this.ID = baseID;
    }

    public Dependencia(String tipo, String baseID) {
        this.nombre = tipo;
        this.ID = baseID;
    }

    public String getTipo() {
        return nombre;
    }

    public void setTipo(String tipo) {
        this.nombre = tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        
        if (this.subTipo != null) {
            
            return this.nombre + ", " + this.subTipo;
            
        } else {
            
            return this.nombre;
            
        }
        
    }
}
