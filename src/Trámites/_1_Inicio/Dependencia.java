package Trámites._1_Inicio;

public class Dependencia {

    private String tipo, subTipo, ID;

    public Dependencia(String tipo, String subTipo) {
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.ID = baseID();
    }

    public Dependencia(String tipo) {
        this.tipo = tipo;
        this.ID = baseID();
    }

    private String baseID() {

        String pref;

        switch (tipo) {
            
            case "Facultades y Programas de Pregrado":
                pref = "FPP_";
                if (subTipo != null) {
                    switch (subTipo) {
                        case "Estudios Generales":
                            return pref + "EG-";
                        case "Arquitectura":
                            return pref + "FA_Arq-";
                        case "Contabilidad":
                            return pref + "FCEE_Con-";
                        case "Economía":
                            return pref + "FCEE_Eco-";
                        case "Negocios Internacionales":
                            return pref + "FCEE_Neg-";
                        case "Administración":
                            return pref + "FCEE_Adm-";
                        case "Marketing":
                            return pref + "FCEE_Mar-";
                        case "Comunicación":
                            return pref + "FC_Com-";
                        case "Derecho":
                            return pref + "FD_Der-";
                        case "Ingeniería Civil":
                            return pref + "FI_Civ-";
                        case "Ingeniería Industrial":
                            return pref + "FI_Ind-";
                        case "Ingeniería de Sistemas":
                            return pref + "FI_Sis-";
                        case "Psicología":
                            return pref + "FP_Psi-";
                        default:
                            throw new RuntimeException("Error: Subtipo desconocido para \"Facultades y Programas de Pregrado\"");
                    }
                } else {
                    throw new RuntimeException("Error: Subtipo es requerido para \"Facultades y Programas de Pregrado\"");
                }
            
            case "Estudios de Posgrado":
                return "POS-";
            
            case "Programas de Educación Ejecutiva":
                return "PEG-";
            
            case "Oficinas Administrativas y Servicios":
                pref = "OAS_";
                if (subTipo != null) {
                    switch (subTipo) {
                        case "Biblioteca":
                            return pref + "Bib-";
                        case "Bienestar":
                            return pref + "Bie-";
                        case "Deportes":
                            return pref + "Dep-";
                        case "Cultura":
                            return pref + "Cul-";
                        case "Fondo Editorial":
                            return pref + "Fon-";
                        case "Relaciones Internacionales":
                            return pref + "Rel-";
                        case "Red de Graduados":
                            return pref + "Red-";
                        default:
                            throw new RuntimeException("Error: Subtipo desconocido para \"Oficinas Administrativas y Servicios\"");
                    }
                } else {
                    throw new RuntimeException("Error: Subtipo es requerido para \"Oficinas Administrativas y Servicios\"");
                }
            case "Centros e Institutos":
                pref = "CI_";
                if (subTipo != null) {
                    switch (subTipo) {
                        case "Centro Cultural":
                            return pref + "CI_CCul-";
                        case "Centro de Empleabilidad":
                            return pref + "CI_CEmpl-";
                        case "Centro de Emprendimiento":
                            return pref + "CI_CEmpr-";
                        case "Observatorio":
                            return pref + "CI_Obs-";
                        case "Instituto de Investigación":
                            return pref + "CI_IInv-";
                        default:
                            throw new RuntimeException("Error: Subtipo desconocido para \"Centros e Instituto\"");
                    }
                } else {
                    throw new RuntimeException("Error: Subtipo es requerido para \"Centros e Instituto\"");
                }
            default:
                throw new RuntimeException("Error: Tipo desconocido");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
