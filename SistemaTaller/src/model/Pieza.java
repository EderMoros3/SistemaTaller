package model;
public class Pieza {
    private int idPieza;
    private String nombre;
    private String referencia;
    private String marca;
    private int cantidad;
    private Double precio;
    private String descripcion;
    

    public Pieza(String nombre, String referencia, String marca, int cantidad, Double precio, String descripcion) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Pieza{");
        sb.append("idPieza=").append(idPieza);
        sb.append(", nombre=").append(nombre);
        sb.append(", referencia=").append(referencia);
        sb.append(", marca=").append(marca);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precio=").append(precio);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }

    

    
}
