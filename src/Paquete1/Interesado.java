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
public class Interesado extends Usuario {

    public Interesado(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    public void verSeguimiento(String expedienteId, SistemaTramite sistema) {
        sistema.mostrarSeguimiento(expedienteId);
    }
}


