package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Proveedor;

public class ProveedorDAO {
    public void insertarProveedor(Proveedor proveedor) {
        String nombre = proveedor.getNombre();
        int idProveedor = proveedor.getIdProveedor();
        int telefono = proveedor.getTelefono();
        String direccion = proveedor.getDireccion();
        String correo = proveedor.getEmail();

        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Proveedor (nombre, idProveedor, telefono, direccion, correo) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idProveedor);
                ps.setInt(3, telefono);
                ps.setString(4, direccion);
                ps.setString(5, correo);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar proveedor: " + e.getMessage());
            }
        }
    }

    public void eliminarProveedor(Proveedor proveedor) {
        int idProveedor = proveedor.getIdProveedor();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Proveedor WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idProveedor);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar proveedor: " + e.getMessage());
            }
        }
    }

    public ArrayList<Proveedor> listarProveedores() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Proveedor";
                
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int telefono = rs.getInt("telefono");
                    String direccion = rs.getString("direccion");
                    String correo = rs.getString("correo");

                    Proveedor proveedor = new Proveedor(nombre, telefono, direccion, correo);
                    proveedores.add(proveedor);
                }
                } catch (SQLException e) {
                    System.err.println("Error al listar proveedores: " + e.getMessage());
                }
            }
            return proveedores;
        }

    public Proveedor getProveedorID(int idProveedor) {
        Connection conexion = ConexionDB.conectar();
        Proveedor proveedor = null;

        if (conexion != null) {
            String query = "SELECT * FROM Proveedor WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idProveedor);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String nombre = rs.getString("nombre");
                        int telefono = rs.getInt("telefono");
                        String direccion = rs.getString("direccion");
                        String correo = rs.getString("correo");

                        proveedor = new Proveedor(nombre, telefono, direccion, correo);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener proveedor por ID: " + e.getMessage());
            }
        }
        return proveedor;
    }

    public void modificarNombreProveedor(int idProveedor, String nombre) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Proveedor SET nombre = ? WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idProveedor);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar nombre del proveedor: " + e.getMessage());
            }
        }
    }

    public void modificarTelefonoProveedor(int idProveedor, int telefono) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Proveedor SET telefono = ? WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, telefono);
                ps.setInt(2, idProveedor);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar telefono del proveedor: " + e.getMessage());
            }
        }
    }

    public void modificarDireccionProveedor(int idProveedor, String direccion) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Proveedor SET direccion = ? WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, direccion);
                ps.setInt(2, idProveedor);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar direccion del proveedor: " + e.getMessage());
            }
        }
    }
    public void modificarEmailProveedor(int idProveedor, String email) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Proveedor SET email = ? WHERE idProveedor = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, email);
                ps.setInt(2, idProveedor);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar email del proveedor: " + e.getMessage());
            }
        }
    }

    public boolean existeTelefono(int telefono) {
        Connection conexion = ConexionDB.conectar();
        boolean existe = false;

        if (conexion != null) {
            String query = "SELECT * FROM Proveedor WHERE telefono = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, telefono);
                try (ResultSet rs = ps.executeQuery()) {
                    existe = rs.next();
                }
            } catch (SQLException e) {
                System.err.println("Error al verificar existencia de telefono: " + e.getMessage());
            }
        }
        return existe;
    }
}
