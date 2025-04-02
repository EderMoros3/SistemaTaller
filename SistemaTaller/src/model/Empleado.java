package model;
public class Empleado {
    // Atributos
    private String nombre;
    private String apellido;
    private int idEmpleado;
    private int telefono;

    public Empleado(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getIdEmpleado() { return idEmpleado; }
    public int getTelefono() { return telefono; }

    // setters
    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

}
