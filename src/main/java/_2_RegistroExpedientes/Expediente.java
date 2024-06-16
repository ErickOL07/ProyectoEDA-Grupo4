package _2_RegistroExpedientes;

public class Expediente
{
   private int Id;
   private int prioridad;
   private Interesado datoInteres;
   private String asunto;
   private String documentoReferencia;// yaya entonces dni o carnet 
   private date fechaInicio; 
   private date fechaFin;
   public Expediente(Interesado datoInteres, String asunto, String documentoReferencia )
    {
     this.datoInteres = datoInteres;
     this.asunto = asunto;
     this.documentoReferencia = documentoReferencia;
   }
}
 