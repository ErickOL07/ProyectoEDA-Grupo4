
import java.util.Date;

public class SistemaTramite {
    private ListaEnlazada<Expediente> listaExpedientes;
    private ListaEnlazada<Dependencia> listaDependencias;

    public SistemaTramite() {
        this.listaExpedientes = new ListaEnlazada<Expediente>();
        this.listaDependencias = new ListaEnlazada<Dependencia>();
    }

    public void registrarExpediente(Dependencia dependencia, Expediente expediente) {
        expediente.setFechaHoraInicio(new Date().toString());
        expediente.agregarMovimiento("Expediente registrado en " + dependencia.getNombre());
        listaExpedientes.insertar(expediente);
        dependencia.agregarExpediente(expediente);
    }

    public void moverExpediente(int expedienteId, String dependenciaDestino) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        Nodo<Dependencia> nodoDependencia = listaDependencias.buscar(new Dependencia(dependenciaDestino));

        if (nodoExpediente != null && nodoDependencia != null) {
            Expediente expediente = nodoExpediente.getData();
            Dependencia nuevaDependencia = nodoDependencia.getData();
            expediente.agregarMovimiento("Expediente movido a " + nuevaDependencia.getNombre());
            nuevaDependencia.agregarExpediente(expediente);
        } else {
            System.out.println("Expediente o dependencia no encontrados");
        }
    }

    public void finalizarExpediente(int expedienteId) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Expediente expediente = nodoExpediente.getData();
            expediente.setFechaHoraFinalizacion(new Date().toString());
            expediente.agregarMovimiento("Expediente finalizado");
        }
    }

    public void mostrarSeguimiento(int expedienteId) {
        Nodo<Expediente> nodoExpediente = buscarExpediente(expedienteId);
        if (nodoExpediente != null) {
            Expediente expediente = nodoExpediente.getData();
            System.out.println("Seguimiento del expediente " + expedienteId);
            System.out.println("Inicio: " + expediente.getFechaHoraInicio());
            System.out.println("Finalización: " + expediente.getFechaHoraFinalizacion());
            expediente.mostrarMovimientos();
        }
    }

    public ListaEnlazada<Expediente> getListaExpedientes() {
        return listaExpedientes;
    }

    public ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }

    private Nodo<Expediente> buscarExpediente(int expedienteId) {
        Nodo<Expediente> current = listaExpedientes.getHead();
        while (current != null) {
            if (current.getData().getId()==expedienteId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
