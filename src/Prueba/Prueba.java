
package Prueba;


public class Prueba {
    public static void main(String[] args) {

        SistemaTramite sistema = new SistemaTramite();

 
        Dependencia dep1 = new Dependencia("Dependencia 1");
        Dependencia dep2 = new Dependencia("Dependencia 2");
        sistema.getListaDependencias().insertar(dep1);
        sistema.getListaDependencias().insertar(dep2);

        // Crear un administrador
        Administrador admin = new Administrador("admin", "password");

        // Crear expedientes
        Expediente exp1 = new Expediente("EXP001", "Alta", "Juan Perez", "Solicitud de permiso", "DOC123");
        Expediente exp2 = new Expediente("EXP002", "Baja", "Maria Lopez", "Solicitud de licencia", "DOC124");

        // Crear personal de dependencia
        PersonalDependencia personalDep1 = new PersonalDependencia("personal1", "password1", dep1);
        PersonalDependencia personalDep2 = new PersonalDependencia("personal2", "password2", dep2);

        // Registrar ingreso de expedientes
        personalDep1.registrarIngresoExpediente(exp1, sistema);
        personalDep1.registrarIngresoExpediente(exp2, sistema);

        // Mover expediente de una dependencia a otra
        personalDep1.registrarMovimientoExpediente("EXP001", "Dependencia 2", sistema);

        // Finalizar expediente
        personalDep2.registrarFinalizacionExpediente("EXP001", sistema);

        // Crear un interesado
        Interesado interesado = new Interesado("juanperez", "password3");

        // Ver el seguimiento de un expediente
        interesado.verSeguimiento("EXP001", sistema);

        // Prueba de administración de cuentas
        admin.administrarCuentas(new Interesado("mariolopez", "password4"), "agregar");
        admin.administrarCuentas(new PersonalDependencia("personal3", "password5", dep1), "agregar");

        // Prueba de administración de dependencias
        admin.administrarDependencias(new Dependencia("Dependencia 3"), "agregar");

        // Imprimir todos los expedientes registrados
        System.out.println("\nLista de expedientes registrados:");
        Nodo<Expediente> currentExp = sistema.getListaExpedientes().getHead();
        while (currentExp != null) {
            System.out.println(currentExp.getData().getId() + ": " + currentExp.getData().getAsunto());
            currentExp = currentExp.getNext();
        }

        // Imprimir todas las dependencias registradas
        System.out.println("\nLista de dependencias registradas:");
        Nodo<Dependencia> currentDep = sistema.getListaDependencias().getHead();
        while (currentDep != null) {
            System.out.println(currentDep.getData().getNombre());
            currentDep = currentDep.getNext();
        }
    }
}

