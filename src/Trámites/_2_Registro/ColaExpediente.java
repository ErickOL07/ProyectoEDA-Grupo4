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
        int id = 0;
        int orden = 0;
        NodoCola nuevo = new NodoCola(expediente);

        if (estaVacia()) {
            front = nuevo;
            rear = nuevo;
            id++;
            orden++;
        } else {
            if (expediente.isPrioridad()) {
                if (!rear.expediente.isPrioridad()) {
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
                }
            } else {
                rear.next = nuevo;
                id++;
                orden++;
            }
        }
        expediente.ID(id);
        expediente.setOrden(orden);
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
