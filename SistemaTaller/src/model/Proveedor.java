package model;

public class Proveedor {
    //Atributos
    private int idProveedor;
    private String nombre;
    private int telefono;
    private String direccion;
    private String email;

    //Constructor
    public Proveedor(String nombre, int telefono, String direccion, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    //Getters
    public int getIdProveedor() {return idProveedor;}
    public String getNombre() {return nombre;}
    public int getTelefono() {return telefono;}
    public String getDireccion() {return direccion;}
    public String getEmail() {return email;}
    
    //Setters
    public void setIdProveedor(int idProveedor) {this.idProveedor = idProveedor;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono
                + ", direccion=" + direccion + ", email=" + email + "]";
    }

    
}
