package Trámites._7_Alertas;

import Trámites._2_Registro.*;
import Trámites._4_Seguimiento.*;
import Trámites._5_Interesados.*;

public class Alerta {
    
    public Alerta() {
    }
     
    public String expedientesNoAtendidos(SistemaTramite sistema, Usuario usuario) {
        
        ColaExpediente aux = new ColaExpediente();
        ColaExpediente C = sistema.getExpedientes();
        String Alarma = "Relación de expedientes no atendidos:\n";
        int orden = 0;
                    
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
                        
            if (orden == 0) {

                return Alarma + "\nNo se encontraron expedientes en cola.";

            }

            return Alarma;
        
        }


    }
