public class LegendEntity {
    
    private int idlegend;
    private String sentido;
    private String color;
    
    
    public LegendEntity(int idlegend, String sentido, String color) {
        super();
        this.idlegend = idlegend;
        this.sentido = sentido;
        this.color = color;
    }
    public int getIdlegend() {
        return idlegend;
    }
    public void setIdlegend(int idlegend) {
        this.idlegend = idlegend;
    }
    public String getSentido() {
        return sentido;
    }
    public void setSentido(String sentido) {
        this.sentido = sentido;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "LegendEntity [idlegend=" + idlegend + ", sentido=" + sentido + ", color=" + color + "]";
    }
    
}
