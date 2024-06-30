package GUI;

import TDA.*;
import Trámites._1_Inicio.*;

public class Acceso extends javax.swing.JPanel {

    public Acceso() {
        initComponents();
        ListaEnlazada<Dependencia> listaDependencias = new ListaEnlazada<>();
        
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

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
