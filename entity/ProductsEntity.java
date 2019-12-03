public class  {
  private int restante;
  private int idwarehouse;
  private int total;
  private String nombreproducts;
  private int idproducts;
  public int getRestante() {
    return restante;
  }
  public void setRestante(int restante) {
    this.restante = restante;
  }
  public int getIdwarehouse() {
    return idwarehouse;
  }
  public void setIdwarehouse(int idwarehouse) {
    this.idwarehouse = idwarehouse;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public String getNombreproducts() {
    return nombreproducts;
  }
  public void setNombreproducts(String nombreproducts) {
    this.nombreproducts = nombreproducts;
  }
  public int getIdproducts() {
    return idproducts;
  }
  public void setIdproducts(int idproducts) {
    this.idproducts = idproducts;
  }
  @Override
  public String toString() {
    return "ProductsEntity [restante=" + restante + ", idwarehouse=" + idwarehouse + ", total=" + total
        + ", nombreproducts=" + nombreproducts + ", idproducts=" + idproducts + "]";
  }
  public ProductsEntity(int restante, int idwarehouse, int total, String nombreproducts, int idproducts) {
    super();
    this.restante = restante;
    this.idwarehouse = idwarehouse;
    this.total = total;
    this.nombreproducts = nombreproducts;
    this.idproducts = idproducts;
  }
  

}
