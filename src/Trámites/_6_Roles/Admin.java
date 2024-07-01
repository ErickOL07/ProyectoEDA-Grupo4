package Trámites._6_Roles;

import TDA.ListaEnlazada;
import TDA.Nodo;
import Trámites._1_Inicio.Dependencia;
import Trámites._5_Interesados.Usuario;
import javax.swing.JOptionPane;

public class Admin extends Usuario {

    private String Nombre;
    private String Apellido;
    private String DNI;

    public Admin(String Nombre, String Apellido, String DNI, String correo, String contraseña) {
        super(correo, contraseña);
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
    }

    public static void agregarDependencia(ListaEnlazada<Dependencia> lista, Dependencia dependencia) {
        if (esDependenciaValida(lista, dependencia)) {
            lista.insertar(dependencia);
        } else {
            JOptionPane.showMessageDialog(null, "Error: Dependencia con características repetidas.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Error: Dependencia con características repetidas.");
        }
    }

    public static void eliminarDependencia(ListaEnlazada<Dependencia> lista, Dependencia dependencia) {
        lista.eliminar(dependencia);
    }

    private static boolean esDependenciaValida(ListaEnlazada<Dependencia> lista, Dependencia nuevaDependencia) {
        Nodo<Dependencia> current = lista.getHead();
        while (current != null) {
            Dependencia existente = current.getData();
            if (existente.getID().equals(nuevaDependencia.getID())) {
                return false;
            }
            if (existente.getTipo().equals(nuevaDependencia.getTipo())
                    && (existente.getSubTipo() == null || existente.getSubTipo().equals(nuevaDependencia.getSubTipo()))) {
                return false;
            }
            current = current.getNext();
        }
        return true;
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
    
    
}
