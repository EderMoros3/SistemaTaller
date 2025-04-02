package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cita;
import model.Cliente;

public class CitaDAO {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public void insertarCita(Cita cita) {
        String fecha = cita.getFecha();
        String hora = cita.getHora();
        String descripcion = cita.getDescripcion();
        Cliente cliente = cita.getCliente();

        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Cita (fecha, hora, descripcion, cliente) VALUES ( ?, ?, ? ,?)";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, fecha);
                ps.setString(2, hora);
                ps.setString(3, descripcion);
                ps.setString(4, cliente.getDni());
                ps.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error al insertar cita: " + e.getMessage());
            }
        }
    }

    public void eliminarCita(Cita cita) {
        int idCita = cita.getIdCita();
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Cita WHERE idCita = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idCita);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar cita: " + e.getMessage());
            }
        }
    }

    public ArrayList<Cita> listarCitas() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Cita> citas = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Cita";
            try (Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String descripcion = rs.getString("descripcion");
                Cliente cliente = clienteDAO.getClienteDni(rs.getString("dni"));
                citas.add(new Cita(cliente, fecha, hora, descripcion ));
            } catch (SQLException e) {
                System.err.println("Error al listar citas: " + e.getMessage());
            }
        }
        return null;
    }

    public ArrayList<Cita> listarCitasCliente(String dni) {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Cita> citas = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Cita WHERE dni = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String fecha = rs.getString("fecha");
                        String hora = rs.getString("hora");
                        String descripcion = rs.getString("descripcion");
                        Cliente cliente = clienteDAO.getClienteDni(rs.getString("dni"));
                        citas.add(new Cita(cliente, fecha, hora, descripcion));
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al listar citas: " + e.getMessage());
            }
        }
        return null;
    }

    public Cita getCitaId(int idCita) {
        Connection conexion = ConexionDB.conectar();
        Cita cita = null;

        if (conexion != null) {
            String query = "SELECT * FROM Cita WHERE idCita = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idCita);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String fecha = rs.getString("fecha");
                        String hora = rs.getString("hora");
                        String descripcion = rs.getString("descripcion");
                        Cliente cliente = clienteDAO.getClienteDni(rs.getString("dni"));
                        cita = new Cita(cliente, fecha, hora, descripcion);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener cita: " + e.getMessage());
            }
        }
        return null;
    }

    public void modificarClienteCita(Cliente cliente, Cita cita) {
        String dni = cliente.getDni();
        int idCita = cita.getIdCita();
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Cita SET dni = ? WHERE idCita = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                ps.setInt(2, idCita);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar cita: " + e.getMessage());
            }
        }
    }

    public void modificarFechaCita(Cita cita, String fecha) {
        Connection conexion = ConexionDB.conectar();

        int idCita = cita.getIdCita();
        if (conexion != null) {
            String query = "UPDATE Cita SET fecha = ? WHERE idCita = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, fecha);
                ps.setInt(2, idCita);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar cita: " + e.getMessage());
            }
        }
    }

    public void modificarHoraCita(Cita cita, String hora) {
        Connection conexion = ConexionDB.conectar();

        int idCita = cita.getIdCita();
        if (conexion != null) {
            String query = "UPDATE Cita SET hora = ? WHERE idCita = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, hora);
                ps.setInt(2, idCita);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar cita: " + e.getMessage());
            }
        }
    }

    public void modificarDescripcionCita(Cita cita, String descripcion) {
        Connection conexion = ConexionDB.conectar();

        int idCita = cita.getIdCita();
        if (conexion != null) {
            String query = "UPDATE Cita SET descripcion = ? WHERE idCita = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, descripcion);
                ps.setInt(2, idCita);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar cita: " + e.getMessage());
            }
        }
    }
}
