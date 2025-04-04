package model;

public class Cita {
    int idCita;
    Cliente cliente;
    String fecha;
    String hora;
    String descripcion;

    //Constructor
    public Cita (Cliente cliente, String fecha, String hora, String descripcion) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    //getters
    public int getIdCita() {return idCita;}
    public Cliente getCliente() {return cliente;}
    public String getFecha() {return fecha;}
    public String getHora() {return hora;}
    public String getDescripcion() {return descripcion;}

    //setters
    public void setIdCita(int idCita) {this.idCita = idCita;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setHora(String hora) {this.hora = hora;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", cliente=" + cliente.getNombre() + " " + cliente.getApellido() + // Mostrar solo nombre y apellido
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


}
