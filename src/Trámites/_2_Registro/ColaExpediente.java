package Trámites._2_Registro;

import Trámites._2_Registro.*;

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
        ColaExpediente colaAux = new ColaExpediente();
        Expediente expedienteEncontrado = null;
        
        while (!estaVacia()) {
            Expediente expedienteActual = desencolar();
            if (expedienteActual.getId().equals(expedienteId)) {
                expedienteEncontrado = expedienteActual;
            }
            colaAux.encolar(expedienteActual);
        }
        
        while (!colaAux.estaVacia()) {
            encolar(colaAux.desencolar());
        }
        
        return expedienteEncontrado;
    }
    
    public void procesarExpediente(String expedienteId) {
        ColaExpediente colaAux = new ColaExpediente();
        boolean encontradoYFinalizado = false;

        while (!estaVacia()) {
            Expediente expedienteActual = desencolar();
            if (expedienteActual.getId().equals(expedienteId) && expedienteActual.isFinalizado()) {
                encontradoYFinalizado = true;
            } else {
                colaAux.encolar(expedienteActual);
            }
        }

        while (!colaAux.estaVacia()) {
            encolar(colaAux.desencolar());
        }

        if (encontradoYFinalizado) {
            System.out.println("Expediente " + expedienteId + " procesado y removido.");
        } else {
            System.out.println("Expediente " + expedienteId + " no encontrado o no finalizado.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoCola current = front;
        while (current != null) {
            sb.append(current.expediente.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
