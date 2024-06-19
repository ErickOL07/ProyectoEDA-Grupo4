package Trámites;


public class Main {
  public static void main(String[] args) {
    SistemaTramite sistema = new SistemaTramite();
    Dependencia dep1 = new Dependencia("Dependencia 1");
    Dependencia dep2 = new Dependencia("Dependencia 2");
    Dependencia dep3 = new Dependencia("Dependencia 3");
    sistema.getListaDependencias().insertar(dep1);
    sistema.getListaDependencias().insertar(dep2);
    sistema.getListaDependencias().insertar(dep3);
    Interesado one = new Interesado("one", "one");
    Interesado two = new Interesado("two", "two");

    Expediente expediente1 = new Expediente(one, "Asunto 1", "Documento referencia 1");
    Expediente expediente2 = new Expediente(two, "Asunto 2", "Documento referencia 2");
    PersonalDependencia personalDep1 = new PersonalDependencia("personal1", "password1", dep1);
    PersonalDependencia personalDep2 = new PersonalDependencia("personal2", "password2", dep2);

    personalDep1.registrarIngresoExpediente(expediente1, sistema);
    personalDep1.registrarIngresoExpediente(expediente2, sistema);
    

    System.out.println(sistema.getListaDependencias().getHead().getData().getNombre());
    System.out.println(sistema.getListaExpedientes().getHead().getData().getAsunto());

    System.out.println(sistema.getListaExpedientes().getHead().getData().getDocumentoReferencia());
    System.out.println("Id del primer expediente a a atender: "+sistema.getListaExpedientes().getHead().getData().getId());
    System.out.println("Prioridad del primer expediente a a atender: "+sistema.getListaExpedientes().getHead().getData().getPrioridad());

    
one.verSeguimiento(1, sistema);
    personalDep1.registrarFinalizacionExpediente(1, sistema);

    one.verSeguimiento(1, sistema);
  }
  
  
}