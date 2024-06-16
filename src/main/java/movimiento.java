public class Movimiento
{
  private date fechadeMovimiento;
  private Dependencia origen;
  private Dependencia destino;
  private Lista<String>documentos;
  public Movimiento(Date fechaHoraMovimiento, Dependencia dependenciaOrigen, Dependencia dependenciaDestino) {
      this.fechaHoraMovimiento = fechaHoraMovimiento;
      this.dependenciaOrigen = dependenciaOrigen;
      this.dependenciaDestino = dependenciaDestino;
      this.documentosAsociados = new Lista<>();
  }
  public void agregarDocumentoAsociado(String documento) {
      documentosAsociados.insertar(documento);
  }
}