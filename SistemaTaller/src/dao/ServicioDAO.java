package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Servicio;

public class ServicioDAO {
    public void insertarServicio(Servicio servicio) {
        String nombre = servicio.getNombre();
        int idServicio = servicio.getIdServicio();
        Double precio = servicio.getPrecioServicio();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "INSERT INTO Servicio (nombre, idServicio, precio) VALUES (?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idServicio);
                ps.setDouble(3, precio);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar servicio: " + e.getMessage());
            }
        }
    }

    public void eliminarServicio(Servicio servicio) {
        int idServicio = servicio.getIdServicio();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Servicio WHERE idServicio = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idServicio);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar servicio: " + e.getMessage());
            }
        }

    }

    public Servicio getServicioID(int idServicio) {
        Connection conexion = ConexionDB.conectar();
        Servicio servicio = null;

        if (conexion != null) {
            String query = "SELECT * FROM Cliente WHERE dni = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idServicio);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String nombre = rs.getString("nombre");
                        Double precio = rs.getDouble("precio");

                        servicio = new Servicio(nombre,precio);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener servicio por ID: " + e.getMessage());
            }
        }
        return servicio;
    }

    public ArrayList<Servicio> listarServicios() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Servicio> servicios = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Servicio";

            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    Double precio = rs.getDouble("precio");
                    

                    Servicio servicio = new Servicio(nombre, precio);
                    servicios.add(servicio);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar clientes: " + e.getMessage());
            }
        return servicios;
        }
        return null;
    }

    public void modificarNombreServicio(String nombre, int idServicio) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Servicio SET nombre = ? WHERE idServicio = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idServicio);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar nombre del servicio: " + e.getMessage());
            }
        }
    }

    public void modificarprecio(Double precio, int idServicio) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Servicio SET precio = ? WHERE idServicio = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setDouble(1, precio);
                stmt.setInt(2, idServicio);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar precio del servicio: " + e.getMessage());
            }
        }
    }

    public void modificarIdServicio(int id, int idServicio) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Servicio SET id = ? WHERE idServicio = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, id);
                stmt.setInt(2, idServicio);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar ID del servicio: " + e.getMessage());
            }
        }
    }

    public ArrayList<Servicio> historialServiciosCliente(String dni) {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Servicio> servicios = new ArrayList<>();
        
        if (conexion != null) {
            String query = "SELECT s.idServicio, s.nombre, s.precio " +
                    "FROM Servicio s " +
                    "JOIN Taller t ON s.idServicio = t.idServicio " +
                    "JOIN Cliente c ON t.dniCliente = c.dniCliente " + 
                    "WHERE c.dniCliente = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        Double precio = rs.getDouble("precio");

                        Servicio servicio = new Servicio(nombre, precio);
                        servicios.add(servicio);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener historial de servicios del cliente: " + e.getMessage());
            }
            return servicios;
        }
        return null;
    }
}
