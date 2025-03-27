package model;
public class Cliente {
    // Atributos
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String email;
    private String dni;

    // Constructor
    public Cliente(String nombre, String apellido, int telefono, String direccion, String email, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.dni = dni;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion="
                + direccion + ", email=" + email + ", dni=" + dni + "]";
    }
}