package Trámites._7_Alertas;

import Trámites._2_Registro.*;
import Trámites._4_Seguimiento.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;

public class Alerta {
    
    public Alerta() {
    }
     
    public String expedientesNoAtendidos(SistemaTramite sistema, Usuario usuario) {
        
        ColaExpediente aux = new ColaExpediente();
        ColaExpediente C = sistema.getExpedientes();
        String Alarma = "Relación de expedientes no atendidos:\n";
        int orden = 0;
        
        if (usuario instanceof Admin) {
            
            while (!C.estaVacia()) {
                
                Expediente M = C.desencolar();
                aux.encolar(M);

                orden++;                
                Alarma += "\n" + orden + ". " + M.getId() + " | " + M.getDependencia().toString() + " | " + M.getAsunto();
                
            }
            while(!aux.estaVacia()) {
                
                C.encolar(aux.desencolar());
                
            }
                        
        }
        
        else if (usuario instanceof Institución || usuario instanceof Persona) {
            
            while (!C.estaVacia()) {
                
                Expediente M = C.desencolar();
                aux.encolar(M);
                
                
                if (M.getDatosInteresado() == usuario) {
                
                    orden++;
                    Alarma += "\n" + orden + ". " + M.getId() + " | " + M.getDependencia().toString() + " | " + M.getAsunto();
                
                }
                
            }
            while(!aux.estaVacia()) {
                
                C.encolar(aux.desencolar());
                
            }
                        
        }
        
        else if (usuario instanceof Personal) {
            
            while (!C.estaVacia()) {
                
                Expediente M = C.desencolar();
                aux.encolar(M);
                
                if (M.getDependencia().getID().equals(((Personal) usuario).getDependenciaID())) {
                
                    orden++;
                    Alarma += "\n" + orden + ". " + M.getId() + " | " + M.getDatosInteresado().toString() + " | " + M.getAsunto();
                
                }
                
            }
            while(!aux.estaVacia()) {
                
                C.encolar(aux.desencolar());
                
            }
                        
        }
        
        if (orden == 0) {
            
            return Alarma + "\nNo se encontraron expedientes en cola.";
            
        }
        
        return Alarma;
        
    }
    
    
}
