package Trámites;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;

public class Datos {
    
    public static ListaEnlazada<Dependencia> listaDependencias = new ListaEnlazada<>();
    public static ListaEnlazada<Usuario> listaUsuarios = new ListaEnlazada<>();
    public static ListaEnlazada<Expediente> expedientesNuevos = new ListaEnlazada<>();
    
    static {
        inicializarListas();
    }

    private static void inicializarListas() {
        // Dependencias:
        
        // Facultades y Programas de Pregrado
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Estudios Generales", "FPP_EG-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Arquitectura", "FPP_FA_Arq-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Contabilidad", "FPP_FCEE_Con-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Economía", "FPP_FCEE_Eco-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Negocios Internacionales", "FPP_FCEE_Neg-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Administración", "FPP_FCEE_Adm-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Marketing", "FPP_FCEE_Mar-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Comunicación", "FPP_FC_Com-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Derecho", "FPP_FD_Der-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería Civil", "FPP_FI_Civ-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería Industrial", "FPP_FI_Ind-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería de Sistemas", "FPP_FI_Sis-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Psicología", "FPP_FP_Psi-"));
        // Estudios de Posgrado
        listaDependencias.insertar(new Dependencia("Estudios de Posgrado", "POS-"));
        // Programas de Educación Ejecutiva
        listaDependencias.insertar(new Dependencia("Programas de Educación Ejecutiva", "PEG-"));
        // Oficinas Administrativas y Servicios
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Biblioteca", "OAS_Bib-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Bienestar", "OAS_Bie-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Deportes", "OAS_Dep-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Cultura", "OAS_Cul-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Fondo Editorial", "OAS_Fon-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Relaciones Internacionales", "OAS_Rel-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Red de Graduados", "OAS_Red-"));
        // Centros e Institutos
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro Cultural", "CI_CCul-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro de Empleabilidad", "CI_CEmpl-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro de Emprendimiento", "CI_CEmpr-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Observatorio", "CI_Obs-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Instituto de Investigación", "CI_IInv-"));
        
        
        // Usuarios:
        
        // Administradores
            listaUsuarios.insertar(new Admin("Hector Gianmarco", "Arrasco Juarez", "76145825", "20223148@aloe.ulima.edu.pe", "76145825"));
            listaUsuarios.insertar(new Admin("Erick", "Obradovich Luna", "70814703", "20221751@aloe.ulima.edu.pe", "70814703"));
            listaUsuarios.insertar(new Admin("Roberto Victor", "Rodenas Rodenas", "71261584", "20222182@aloe.ulima.edu.pe", "71261584"));
            listaUsuarios.insertar(new Admin("Claudia Patricia", "Sipion Guillen", "70901486", "20224062@aloe.ulima.edu.pe", "70901486"));
        // Personal de dependencia
            // Facultades y Programas de Pregrado, Ingeniería de Sistemas
            listaUsuarios.insertar(new Personal("Jim Bryan", "Dios Luna", "10101010", "FPP_FI_Sis-", "jdios@aloe.ulima.edu.pe", "sistemas"));
            // Estudios de Posgrado
            listaUsuarios.insertar(new Personal("Gepeto", "Fossati", "00000001", "POS-", "gfossati@aloe.ulima.edu.pe", "posgrado"));
            // Oficinas Administrativas y Servicios, Deportes
            listaUsuarios.insertar(new Personal("Christian Alberto", "Cueva Bravo", "12345678", "OAS_Dep-", "ccueva@aloe.ulima.edu.pe", "deportes"));
        // Interesados comunes
            // Persona
            listaUsuarios.insertar(new Persona("Makanaky", "La Realeza", "66666666", "makanaky@gmail.com", "makanaky"));
            // Institución
            listaUsuarios.insertar(new Institución("USB", "USB@ucv.edu.pe", "paolo"));

    }
    
}
