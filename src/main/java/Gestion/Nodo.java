package Gestion;

public class Nodo
{
private Expediente valor;
private Nodo siguiente;
public Nodo(Expediente valor)
{
this.valor = valor;
this.siguiente = null;  
}
public Expediente getValor()
{
return valor;
}
public void setValor(Expediente valor)
{
this.valor = valor;
}
public Nodo getSiguiente()
{
return siguiente;
}
public void setSiguiente(Nodo siguiente)
{
  this.siguiente = siguiente;
}
}