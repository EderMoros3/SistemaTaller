package model;
public class Pieza {
    private String referencia;
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private int cantidad;
    private int idPieza;

    public Pieza(String referencia, String nombre, String marca, String descripcion, Double precio, int cantidad) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // getters
    public String getReferencia() { return referencia; }
    public String getMarca() { return marca; }
    public String getDescripcion() { return descripcion; }
    public Double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public String getNombre() { return nombre; }
    public int getIdPieza() { return idPieza; }

    // setters
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdPieza(int idPieza) { this.idPieza = idPieza; }

    @Override
    public String toString() {
        return "Pieza [referencia=" + referencia + ", nombre=" + nombre + ", marca=" + marca + ", descripcion="
                + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", idPieza=" + idPieza + "]";
    }

    
}
