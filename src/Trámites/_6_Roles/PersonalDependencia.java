package Trámites._6_Roles;


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

    public void registrarMovimientoExpediente(int expedienteId, String dependenciaDestino, SistemaTramite sistema) {
        sistema.moverExpediente(expedienteId, dependenciaDestino);
        System.out.println("Expediente movido a " + dependenciaDestino);
    }

    public void registrarFinalizacionExpediente(int expedienteId, SistemaTramite sistema) {
        sistema.finalizarExpediente(expedienteId);
        System.out.println("Expediente finalizado");
    }
}
