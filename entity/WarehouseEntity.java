 public class WarehouseEntity {

  private String max;
  private String min;
  private String nombrewarehouse;
  private int idwarehouse;
  public String getMax() {
    return max;
  }
  public void setMax(String max) {
    this.max = max;
  }
  public String getMin() {
    return min;
  }
  public void setMin(String min) {
    this.min = min;
  }
  public String getNombrewarehouse() {
    return nombrewarehouse;
  }
  public void setNombrewarehouse(String nombrewarehouse) {
    this.nombrewarehouse = nombrewarehouse;
  }
  public int getIdwarehouse() {
    return idwarehouse;
  }
  public void setIdwarehouse(int idwarehouse) {
    this.idwarehouse = idwarehouse;
  }
  @Override
  public String toString() {
    return "WarehouseEntity [max=" + max + ", min=" + min + ", nombrewarehouse=" + nombrewarehouse + ", idwarehouse="
        + idwarehouse + "]";
  }
  public WarehouseEntity(String max, String min, String nombrewarehouse, int idwarehouse) {
    super();
    this.max = max;
    this.min = min;
    this.nombrewarehouse = nombrewarehouse;
    this.idwarehouse = idwarehouse;
  }
  

  }
