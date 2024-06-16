package Gestion;

import Expediente;

public class Lista {
  public Nodo L;

  public Lista() {
    L = null;
  }

  public void insertar(Expediente e) {
    Nodo nuevo = new Nodo(e);
    Nodo ptr = L;
    if (L == null) {
      L = nuevo;
    } else {
      while (ptr.getSiguiente() != null) {
        ptr = ptr.getSiguiente();
      }
      ptr.setSiguiente(nuevo);
    }
  }
// Hiciste lo de usuario? o no es necesario?
  
}