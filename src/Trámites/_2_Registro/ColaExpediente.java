package Trámites._2_Registro;


public class ColaExpediente {
    private class NodoCola {
        private Expediente expediente;
        private NodoCola next;

        public NodoCola(Expediente expediente) {
            this.expediente = expediente;
            this.next = null;
        }
    }

    private NodoCola front;
    private NodoCola rear;

    public ColaExpediente() {
        this.front = null;
        this.rear = null;
    }

    public boolean estaVacia() {
        return front == null;
    }

    public void encolar(Expediente expediente) {
         int id=0;
         int prioridad=0;
        NodoCola nuevo = new NodoCola(expediente);
        if (estaVacia()) {
            front = nuevo;
            rear = nuevo;
            id++;
            prioridad++;
        } else {
            rear.next = nuevo;
            rear = nuevo;
            id++;
            prioridad++;
        }
        expediente.setid(id); 
        expediente.setPrioridad(prioridad);
    }

    public Expediente desencolar() {
        if (estaVacia()) {
            return null;
        }
        Expediente expediente = front.expediente;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return expediente;
    }
}
