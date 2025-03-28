package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
    public void insertarCliente(Cliente cliente) {
        String nombre = cliente.getNombre();
        String apellido = cliente.getApellido();
        int telefono = cliente.getTelefono();
        String direccion = cliente.getDireccion();
        String email = cliente.getEmail();
        String dni = cliente.getDni();

        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Cliente (nombre, apellido, telefono, direccion, email, dni) VALUES ( ?, ?, ? ,?, ?, ?)";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, telefono);
                ps.setString(4, direccion);
                ps.setString(5, email);
                ps.setString(6, dni);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("Error al insertar cliente: " + e.getMessage());
            }
        
        
        
        }
    }

    public void eliminarCliente( Cliente cliente) {
        String dni = cliente.getDni();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Cliente WHERE dni = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar cliente: " + e.getMessage());
                
            }
        }
    }

    public ArrayList<Cliente> listarClientes() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Cliente> clientes = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Cliente";

            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        return null;
    }

    public Cliente getClienteDni() {
        // SELECT SQL
        return null;
    }

    public void actualizarNombreCliente(String nombre) {
        // UPDATE SQL
    }

    public void actualizarApellidoCliente(String apellido) {
        // UPDATE SQL
    }

    public void actualizarTlfCliente(int apellido) {
        // UPDATE SQL
    }

    public void actualizarDireccionCliente(String direccion) {
        // UPDATE SQL
    }

    public void actualizarEmailCliente(String email) {
        // UPDATE SQL
    }

    public void actualizarDniCliente(String dni) {
        // UPDATE SQL
    }
}
