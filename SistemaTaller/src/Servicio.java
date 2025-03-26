public class Servicio {
    String nombre;
    int idServicio;
    Double precioServicio;

    public Servicio(String nombre, int idServicio, Double precioServicio) {
        this.nombre = nombre;
        this.idServicio = idServicio;
        this.precioServicio = precioServicio;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public Double getPrecioServicio() {
        return precioServicio;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setPrecioServicio(Double precioServicio) {
        this.precioServicio = precioServicio;
    }
}
