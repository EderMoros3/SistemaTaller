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
}
