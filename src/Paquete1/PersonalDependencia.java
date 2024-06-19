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
public class PersonalDependencia extends Usuario {
    private Dependencia dependencia;

    public PersonalDependencia(String nombreUsuario, String contraseña, Dependencia dependencia) {
        super(nombreUsuario, contraseña);
        this.dependencia = dependencia;
    }

    public void registrarIngresoExpediente(Expediente expediente, SistemaTramite sistema) {
        sistema.registrarExpediente(dependencia, expediente);
        System.out.println("Expediente registrado en " + dependencia.getNombre());
    }

    public void registrarMovimientoExpediente(String expedienteId, String dependenciaDestino, SistemaTramite sistema) {
        sistema.moverExpediente(expedienteId, dependenciaDestino);
        System.out.println("Expediente movido a " + dependenciaDestino);
    }

    public void registrarFinalizacionExpediente(String expedienteId, SistemaTramite sistema) {
        sistema.finalizarExpediente(expedienteId);
        System.out.println("Expediente finalizado");
    }
}


