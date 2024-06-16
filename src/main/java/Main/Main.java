package Main;

import java.time.LocalDateTime;
public class Main {
  public static void main(String[] args) {
   LocalDateTime now = LocalDateTime.now();
   date alejo= new date(now);
   System.out.println(alejo.getFechaString()); // hola
  }

}