/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

/**
 *
 * @author Gianmarco Arrasco
 */
public class Administrador extends Usuario {
    private ListaEnlazada<Usuario> listaUsuarios;
    private ListaEnlazada<Dependencia> listaDependencias;

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
        this.listaUsuarios = new ListaEnlazada<>();
        this.listaDependencias = new ListaEnlazada<>();
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

