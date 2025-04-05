package model;
public class Servicio {
    String nombre;
    int idServicio;
    Double precio;

    public Servicio(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // getters
    public String getNombre() { return nombre; }
    public int getIdServicio() { return idServicio; }
    public Double getPrecioServicio() { return precio; }

    // setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public void setPrecioServicio(Double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Servicio [nombre=" + nombre + ", idServicio=" + idServicio + ", precio=" + precio + "]";
    }

    
}
