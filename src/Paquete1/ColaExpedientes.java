/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

/**
 *
 * @author Gianmarco Arrasco
 */
public class ColaExpedientes {
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

    public ColaExpedientes() {
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
            rear.next = nuevo;
            rear = nuevo;
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
}
