
import tda.*;


public class Administrador extends Usuario {
    private ListaEnlazada<Usuario> listaUsuarios;
    private ListaEnlazada<Dependencia> listaDependencias;

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
        this.listaUsuarios = new ListaEnlazada<Usuario>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
    }

    public void administrarCuentas(Usuario usuario, String accion) {
        if (accion.equalsIgnoreCase("agregar")) {
            listaUsuarios.insertar(usuario);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            listaUsuarios.eliminar(usuario);
        }
    }

    public void administrarDependencias(Dependencia dependencia, String accion) {
        if (accion.equalsIgnoreCase("agregar")) {
            listaDependencias.insertar(dependencia);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            listaDependencias.eliminar(dependencia);
        }
    }

    public void administrarEmpleados(Usuario empleado, String accion) {
        if (accion.equalsIgnoreCase("agregar")) {
            listaUsuarios.insertar(empleado);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            listaUsuarios.eliminar(empleado);
        }
    }
}
