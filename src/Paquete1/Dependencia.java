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
public class Dependencia {
    private String nombre;
    private ColaExpedientes expedientes;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.expedientes = new ColaExpedientes();
    }

    public String getNombre() {
        return nombre;
    }

    public ColaExpedientes getExpedientes() {
        return expedientes;
    }

    public void agregarExpediente(Expediente expediente) {
        expedientes.encolar(expediente);
    }

    public Expediente procesarExpediente() {
        return expedientes.desencolar();
    }
}


