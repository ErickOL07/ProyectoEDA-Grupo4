/*
package Trámites;

import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._3_FlujoRegistro.*;
import Trámites._4_Seguimiento.*;
import Trámites._6_Roles.Usuario;

public class Main {

    public static void main(String[] args) {
        // Crear dependencias
        Dependencia dependencia1 = new Dependencia("Facultades y Programas de Pregrado", "Ingeniería de Sistemas");
        Dependencia dependencia2 = new Dependencia("Oficinas Administrativas y Servicios", "Biblioteca");

        // Crear interesado
        Usuario interesado = new Usuario("usuario123", "password");

        // Crear expediente
        Expediente expediente = new Expediente(dependencia1, true, interesado, "Asunto del trámite", "Documento de referencia");

        // Crear sistema de trámite
        SistemaTramite sistema = new SistemaTramite();

        // Registrar expediente
        Trámite trámite = new Trámite();
        sistema.registrarExpediente(dependencia1, expediente, trámite);

        // Mostrar seguimiento inicial
        interesado.verSeguimiento(expediente.getId(), sistema);

        // Mover expediente a otra dependencia
        sistema.moverExpediente(expediente.getId(), dependencia2);

        // Mostrar seguimiento después de mover expediente
        interesado.verSeguimiento(expediente.getId(), sistema);

        // Finalizar expediente
        sistema.finalizarExpediente(expediente.getId());

        // Mostrar seguimiento final
        interesado.verSeguimiento(expediente.getId(), sistema);

        // Procesar expediente
        Expediente procesado = sistema.procesarExpediente();
        if (procesado != null) {
            System.out.println("Expediente procesado: " + procesado.getId());
        } else {
            System.out.println("No hay expedientes en la cola para procesar.");
        }

        // Crear otra prueba de expediente con prioridad normal
        Expediente expediente2 = new Expediente(dependencia2, false, interesado, "Otro Asunto", "Otro Documento");
        sistema.registrarExpediente(dependencia2, expediente2, trámite);
        
        // Mostrar seguimiento del nuevo expediente
        interesado.verSeguimiento(expediente2.getId(), sistema);
        
        // Mostrar estado final del sistema
        System.out.println("Trámites registrados: " + sistema.getListaTrámites().contar());
        System.out.println("Dependencias registradas: " + sistema.getListaDependencias().contar());
    }
}

*/
