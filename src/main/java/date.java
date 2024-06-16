import java.time.LocalDateTime;//GAAAA
import java.time.format.DateTimeFormatter;// herector
public class date
{
  private LocalDateTime fecha;
  private String fechaString;
  public date(LocalDateTime fecha){
    this.fecha = fecha;
    this.fechaString = 
   fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }
  public String getFechaString(){
    return fechaString;
  }
  public void setFechaString(String fechaString){
    this.fechaString = fechaString;
  }
  public String getFecha(){
    return fecha.toString();
  }
  public void setFecha(LocalDateTime fecha){
    this.fecha = fecha;
    this.fechaString = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }
}