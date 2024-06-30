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
    private int id;

    public ColaExpediente() {
        this.front = null;
        this.rear = null;
        this.id = 1;
    }

    public boolean estaVacia() {
        return front == null;
    }

    public void encolar(Expediente expediente) {
        NodoCola nuevo = new NodoCola(expediente);
        
        if (estaVacia()) {
            front = nuevo;
            rear = nuevo;
        } else {
            if (expediente.isPrioridad()) {
                NodoCola temp = front;
                NodoCola prev = null;

                while (temp != null && temp.expediente.isPrioridad()) {
                    prev = temp;
                    temp = temp.next;
                }
                if (prev == null) {
                    nuevo.next = front;
                    front = nuevo;
                } else {
                    nuevo.next = temp;
                    prev.next = nuevo;
                }
                if (temp == null) {
                    rear = nuevo;
                }
            } else {
                rear.next = nuevo;
                rear = nuevo;
            }
        }
        expediente.ID(id++);
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

    public Expediente buscarExpediente(String expedienteId) {
        NodoCola current = front;
        while (current != null) {
            if (current.expediente.getId().equals(expedienteId)) {
                return current.expediente;
            }
            current = current.next;
        }
        return null;
    }

}
