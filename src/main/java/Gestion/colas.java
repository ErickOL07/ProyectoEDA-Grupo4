package Gestion;

public class colas {
    private int [] datos;
    private int front; // posicion del inicio
    private int back;  // posicion del final
    int MAX_SIZE = 20;

    public colas() {
        datos = new int[MAX_SIZE];
        front = -1;
        back = -1;
    }

    public boolean estaVacia() {
        if (front == -1 && back == -1)
            return true;
        return false;
    }

    public boolean estaLlena() {
        if ((back + 1) == front || ((front == 0) && (back == MAX_SIZE - 1)) )
            return true;
        return false;
    }

    public void encolar(int item) {
        if(!estaLlena()) {
            if (estaVacia()) {
                front = 0;
                back = 0;
            }
            else if (back != MAX_SIZE - 1)
                back++;
            else
                back = 0;
            datos[back] = item;
        }
    }

    public int desencolar() {
        if(!estaVacia()) {
            int item = datos[front];
            datos[front] = -999;
            if (front == back) {
                front = -1;
                back = -1;
            }
            else if (front != MAX_SIZE - 1)
                front++;
            else {
                front = 0;
            }
            return item;
        }
        else {
            System.out.println("La cola esta vacia");
            return -1;
        }
    }

    public void mostrarCola() {
        for (int i=0; i < MAX_SIZE; i++)
            System.out.print(datos[i] + " | ");
        System.out.println("");
    }


    public int cant(int ini,int fin)
    {
       colas r3=  new colas();
       int toñito;
       int cant=0;
       while(!this.estaVacia())
       {
         toñito=this.desencolar();
         if(toñito>=ini && toñito<=fin)
         {
           cant++;  
         }
         r3.encolar(toñito);
       } 
       int jeremias;
       while(!r3.estaVacia())
       {
         jeremias=r3.desencolar();
         this.encolar(jeremias);
       }
       return cant;
    }
}