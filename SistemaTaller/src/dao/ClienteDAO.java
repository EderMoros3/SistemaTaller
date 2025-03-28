package dao;

import java.sql.Statement;
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
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int telefono = rs.getInt("telefono");
                    String direccion = rs.getString("direccion");
                    String email = rs.getString("email");
                    String dni = rs.getString("dni");

                    Cliente cliente = new Cliente(nombre, apellido, telefono, direccion, email, dni);
                    clientes.add(cliente);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar clientes: " + e.getMessage());
            }
        return clientes;
        }
        return null;
    }

    public Cliente getClienteDni(String dni) {
        Connection conexion = ConexionDB.conectar();
        Cliente cliente = null;

        if (conexion != null) {
            String query = "SELECT * FROM Cliente WHERE dni = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        int telefono = rs.getInt("telefono");
                        String direccion = rs.getString("direccion");
                        String email = rs.getString("email");

                        cliente = new Cliente(nombre, apellido, telefono, direccion, email, dni);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener cliente por DNI: " + e.getMessage());
            }
        }
        return cliente;
    }

    public void actualizarNombreCliente(String dni, String nombre) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Cliente SET nombre = ? WHERE dni = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setString(2, dni);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar nombre del cliente: " + e.getMessage());
            }
        }
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
