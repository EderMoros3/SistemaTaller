public class Empleado {
    //Atributos
    private String nombre;
    private String apellido;
    private int idEmpleado;
    private int telefono;

    public Empleado(String nombre, String apellido, int idEmpleado, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEmpleado = idEmpleado;
        this.telefono = telefono;
    }

    //getter
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public int getIdEmpleado() {return idEmpleado;}
    public int getTelefono() {return telefono;}

}

