package model;
public class Servicio {
    String nombre;
    int idServicio;
    Double precio; // Cambiado de "precioServicio" a "precio"

    public Servicio(String nombre, Double precio) { // Cambiado de "precioServicio" a "precio"
        this.nombre = nombre;
        this.precio = precio;
    }

    // getters
    public String getNombre() { return nombre; }
    public int getIdServicio() { return idServicio; }
    public Double getPrecio() { return precio; } // Cambiado de "getPrecioServicio" a "getPrecio"

    // setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public void setPrecio(Double precio) { this.precio = precio; } // Cambiado de "setPrecioServicio" a "setPrecio"

    @Override
    public String toString() {
        return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", precio=" + precio + "]"; // Cambiado de "precioServicio" a "precio"
    }

    
}
