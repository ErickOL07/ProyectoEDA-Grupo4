package Trámites;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._3_FlujoRegistro.*;
import Trámites._4_Seguimiento.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import javax.swing.JOptionPane;

public class Datos {
    
    public static ListaEnlazada<Dependencia> listaDependencias = new ListaEnlazada<>();
    public static ListaEnlazada<Usuario> listaUsuarios = new ListaEnlazada<>();
    public static Cola expedientesNuevos = new Cola<>();
    public static SistemaTramite sistema = new SistemaTramite();
    
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
            // Facultades y Programas de Pregrado, Estudios Generales
            listaUsuarios.insertar(new Personal("Gustavo Ruy", "Jiménez Mendoza", "01010101", "FPP_EG-", "gjmenez@aloe.ulima.edu.pe", "etica"));
            // Estudios de Posgrado
            listaUsuarios.insertar(new Personal("Gepeto", "Fossati", "00000001", "POS-", "gfossati@aloe.ulima.edu.pe", "posgrado"));
            // Oficinas Administrativas y Servicios, Deportes
            listaUsuarios.insertar(new Personal("Christian Alberto", "Cueva Bravo", "12345678", "OAS_Dep-", "ccueva@aloe.ulima.edu.pe", "deportes"));
        // Interesados comunes
            // Persona
            listaUsuarios.insertar(new Persona("Makanaky", "La Realeza", "66666666", "makanaky@gmail.com", "makanaky"));
            // Institución
            listaUsuarios.insertar(new Institución("USB", "USB@ucv.edu.pe", "paolo"));
            listaUsuarios.insertar(new Institución("Bembos", "administracion@bembos.com.pe", "bembos"));
            
            
        // Expedientes:
        
        Expediente expediente1 = new Expediente(buscarDependencia("FPP_FI_Sis-"), 
                                    false, 
                                    buscarUsuario("makanaky@gmail.com"),
                                    "Solicitud de clase piloto",
                                    "SolicitudClasePiloto.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FI_Sis-"), expediente1);
        sistema.finalizarExpediente("FPP_FI_Sis-0000000001");
        
        Expediente expediente2 = new Expediente(buscarDependencia("PEG-"), 
                                    false, 
                                    buscarUsuario("makanaky@gmail.com"),
                                    "Reclamo",
                                    "Informe.pdf");
        sistema.registrarExpediente(buscarDependencia("PEG-"), expediente2);
        sistema.moverExpediente("PEG-0000000002", buscarDependencia("OAS_Cul-"));
        sistema.agregarDocumento("PEG-0000000002", "Respuesta.pdf");
        
        Expediente expediente3 = new Expediente(buscarDependencia("OAS_Bie-"), 
                                    false, 
                                    buscarUsuario("gfossati@aloe.ulima.edu.pe"),
                                    "Solicitud de apoyo económico",
                                    "SolicitudApoyoEconomico.pdf");
        sistema.registrarExpediente(buscarDependencia("OAS_Bie-"), expediente3);
        sistema.agregarDocumento("OAS_Bie-0000000003", "EvaluacionApoyo.pdf");

        Expediente expediente4 = new Expediente(buscarDependencia("CI_CCul-"), 
                                    false, 
                                    buscarUsuario("USB@ucv.edu.pe"),
                                    "Solicitud de uso de instalaciones",
                                    "SolicitudUsoInstalaciones.pdf");
        sistema.registrarExpediente(buscarDependencia("CI_CCul-"), expediente4);
        sistema.moverExpediente("CI_CCul-0000000004", buscarDependencia("OAS_Cul-"));
        
        Expediente expediente5 = new Expediente(buscarDependencia("FPP_FCEE_Adm-"), 
                                    false, 
                                    buscarUsuario("jdios@aloe.ulima.edu.pe"),
                                    "Revisión de plan de estudios",
                                    "RevisionPlanEstudios.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FCEE_Adm-"), expediente5);
        sistema.moverExpediente("FPP_FCEE_Adm-0000000005", buscarDependencia("FPP_FCEE_Con-"));
        sistema.agregarDocumento("FPP_FCEE_Adm-0000000005", "InformeFinal.pdf");

        Expediente expediente6 = new Expediente(buscarDependencia("OAS_Fon-"), 
                                    false, 
                                    buscarUsuario("ccueva@aloe.ulima.edu.pe"),
                                    "Solicitud de publicación",
                                    "SolicitudPublicacion.pdf");
        sistema.registrarExpediente(buscarDependencia("OAS_Fon-"), expediente6);
        sistema.finalizarExpediente("OAS_Fon-0000000006");

        Expediente expediente7 = new Expediente(buscarDependencia("FPP_FCEE_Eco-"), 
                                    false, 
                                    buscarUsuario("makanaky@gmail.com"),
                                    "Solicitud de beca",
                                    "SolicitudBeca.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FCEE_Eco-"), expediente7);
        sistema.agregarDocumento("FPP_FCEE_Eco-0000000007", "EvaluacionBeca.pdf");

        Expediente expediente8 = new Expediente(buscarDependencia("OAS_Dep-"), 
                                    true, 
                                    buscarUsuario("gfossati@aloe.ulima.edu.pe"),
                                    "Informe de actividades deportivas",
                                    "InformeActividadesDeportivas.pdf");
        sistema.registrarExpediente(buscarDependencia("OAS_Dep-"), expediente8);
        sistema.moverExpediente("OAS_Dep-0000000008", buscarDependencia("OAS_Bie-"));

        Expediente expediente9 = new Expediente(buscarDependencia("CI_Obs-"), 
                                    false, 
                                    buscarUsuario("USB@ucv.edu.pe"),
                                    "Informe de investigación",
                                    "InformeInvestigacion.pdf");
        sistema.registrarExpediente(buscarDependencia("CI_Obs-"), expediente9);
        sistema.agregarDocumento("CI_Obs-0000000009", "EvaluacionInvestigacion.pdf");

        Expediente expediente10 = new Expediente(buscarDependencia("POS-"), 
                                    false, 
                                    buscarUsuario("ccueva@aloe.ulima.edu.pe"),
                                    "Inscripción a curso de posgrado",
                                    "InscripcionCursoPosgrado.pdf");
        sistema.registrarExpediente(buscarDependencia("POS-"), expediente10);
        sistema.finalizarExpediente("POS-0000000010");

        Expediente expediente11 = new Expediente(buscarDependencia("FPP_FP_Psi-"), 
                                    false, 
                                    buscarUsuario("makanaky@gmail.com"),
                                    "Solicitud de asesoramiento psicológico",
                                    "SolicitudAsesoramientoPsicologico.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FP_Psi-"), expediente11);
        sistema.agregarDocumento("FPP_FP_Psi-0000000011", "EvaluacionPsicologica.pdf");
     
        Expediente expediente12 = new Expediente(buscarDependencia("FPP_FI_Sis-"), 
                                    true, 
                                    buscarUsuario("jdios@aloe.ulima.edu.pe"),
                                    "Solicitud de actualización de software",
                                    "SolicitudActualizacionSoftware.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FI_Sis-"), expediente12);
        sistema.agregarDocumento("FPP_FI_Sis-0000000012", "EvaluacionActualizacion.pdf");

        Expediente expediente13 = new Expediente(buscarDependencia("FPP_FI_Sis-"), 
                                    false, 
                                    buscarUsuario("makanaky@gmail.com"),
                                    "Solicitud de tutoría en programación",
                                    "SolicitudTutoriaProgramacion.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FI_Sis-"), expediente13);
        sistema.moverExpediente("FPP_FI_Sis-0000000013", buscarDependencia("FPP_FCEE_Con-"));

        Expediente expediente14 = new Expediente(buscarDependencia("FPP_FI_Sis-"), 
                                    true, 
                                    buscarUsuario("gfossati@aloe.ulima.edu.pe"),
                                    "Solicitud de acceso a laboratorio",
                                    "SolicitudAccesoLaboratorio.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FI_Sis-"), expediente14);
        sistema.finalizarExpediente("FPP_FI_Sis-0000000014");

        Expediente expediente15 = new Expediente(buscarDependencia("FPP_FI_Sis-"), 
                                    false, 
                                    buscarUsuario("USB@ucv.edu.pe"),
                                    "Revisión de proyecto de software",
                                    "RevisionProyectoSoftware.pdf");
        sistema.registrarExpediente(buscarDependencia("FPP_FI_Sis-"), expediente15);
        sistema.agregarDocumento("FPP_FI_Sis-0000000015", "InformeRevision.pdf");

    }
    
    public static Dependencia buscarDependencia(String baseID) {
        Nodo<Dependencia> ptr = listaDependencias.getHead();
        while (ptr != null) {
            if (ptr.getData().getID().equals(baseID)) {
                return ptr.getData();
            }
            ptr = ptr.getNext();
        }
        JOptionPane.showMessageDialog(null, "No se encontró la dependencia con ID base: " + baseID, "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public static Usuario buscarUsuario(String correo) {
        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            if (ptr.getData().getCorreo().equals(correo)) {
                return ptr.getData();
            }
            ptr = ptr.getNext();
        }
        JOptionPane.showMessageDialog(null, "No se encontró el usuario con correo electrónico: " + correo, "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public static ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }

    public static ListaEnlazada<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static Cola getExpedientesNuevos() {
        return expedientesNuevos;
    }

    public static SistemaTramite getSistema() {
        return sistema;
    }
    
    
}
    

