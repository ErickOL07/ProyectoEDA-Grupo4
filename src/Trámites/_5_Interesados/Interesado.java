package Trámites._5_Interesados;

import Trámites._3_FlujoRegistro.SistemaTramite;
import Trámites._6_Roles.Usuario;
import Trámites._4_Seguimiento.*;

public class Interesado extends Usuario {

    public Interesado(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    public void verSeguimiento(int expedienteId, SistemaTramite sistema) {
        sistema.mostrarSeguimiento(expedienteId);
    }

// acceso para que el usuario vea todo lo de la expediente
}
