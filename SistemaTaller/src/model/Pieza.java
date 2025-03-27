package model;
public class Pieza {
    private int idPieza;
    private String referencia;
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private int cantidad;

    public Pieza(String referencia, String marca, String descripcion, Double precio, int cantidad, String nombre, int idPieza) {
        this.referencia = referencia;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.idPieza = idPieza;
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

}
