package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Empleado;

public class EmpleadoDAO {
    public void insertarEmpleado(Empleado empleado) {
        String nombre = empleado.getNombre();
        String apellido = empleado.getApellido();
        int idEmpleado = empleado.getIdEmpleado();
        int telefono = empleado.getTelefono();

        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Empleado (nombre, apellido, idEmpleado, telefono) VALUES ( ?, ?, ? ,?)";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, idEmpleado);
                ps.setInt(4, telefono);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("Error al insertar empleado: " + e.getMessage());
            }
        
        
        
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        int idEmpleado = empleado.getIdEmpleado();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Empledao WHERE idEmpleado = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idEmpleado);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar empleado: " + e.getMessage());
                
            }
        }
    }

    public Empleado getIdEmpleado(int idEmpleado) {
        Connection conexion = ConexionDB.conectar();
        Empleado empleado = null;

        if (conexion != null) {
            String query = "SELECT * FROM Empleado WHERE idEmpleado = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idEmpleado);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        int telefono = rs.getInt("telefono");

                        empleado = new Empleado(nombre, apellido, telefono, idEmpleado);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener empleado por ID: " + e.getMessage());
            }
        }
        return empleado;
    }

    public ArrayList<Empleado> listarEmpleados() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Empleado> empleados = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Empleado";

            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int idEmpleado = rs.getInt("idEmpleado");
                    int telefono = rs.getInt("telefono");
                    

                    Empleado empleado = new Empleado(nombre, apellido, idEmpleado, telefono);
                    empleados.add(empleado);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar empleados: " + e.getMessage());
            }
        return empleados;
        }
        return null;
    }

    public void actualizarNombreEmpleado(String nombre, int idEmpleado) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Empleado SET nombre = ? WHERE idEmpleado = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idEmpleado);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar nombre del empleado: " + e.getMessage());
            }
        }
    }

    public void actualizarApellidoEmpleado(String apellido, int idEmpleado) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Empleado SET apellido = ? WHERE idEmpleado = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, apellido);
                stmt.setInt(2, idEmpleado);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar apellido del empleado: " + e.getMessage());
            }
        }
    }

    public void actualizarTlfEmpleado(int telefono, int idEmpleado) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Empleado SET telefono = ? WHERE dni = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, telefono);
                stmt.setInt(2, idEmpleado);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar telefono del empleado: " + e.getMessage());
            }
        }
    }

    public void actualizarIdEmpleado(int idEmpleado) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Cliente SET idEmpleado = ? WHERE idEmpleado = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, idEmpleado);
                stmt.setInt(2, idEmpleado);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar ID del empleado: " + e.getMessage());
            }
        }
    }
}
