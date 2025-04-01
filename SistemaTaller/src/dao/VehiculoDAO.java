package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Vehiculo;

public class VehiculoDAO {
    public void insertarVehiculo(Vehiculo vehiculo) {
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int year = vehiculo.getYear();

        String dni = vehiculo.getTitular().getDni();

        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "INSERT INTO Vehiculo (matricula, marca, modelo, year, dni) VALUES (?, ?, ?, ?, ?)";
            try (var ps = conexion.prepareStatement(query)) {
                ps.setString(1, matricula);
                ps.setString(2, marca);
                ps.setString(3, modelo);
                ps.setInt(4, year);
                ps.setString(5, dni);
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println("Error al insertar vehiculo: " + e.getMessage());
            }
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        String matricula = vehiculo.getMatricula();

        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "DELETE FROM Vehiculo WHERE matricula = ?";
            try (var ps = conexion.prepareStatement(query)) {
                ps.setString(1, matricula);
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println("Error al eliminar vehiculo: " + e.getMessage());
            }
        }
    }

    public Vehiculo getVehiculoMatricula(String matricula) {
        Connection conexion = ConexionDB.conectar();
        Vehiculo vehiculo = null;

        if (conexion != null) {
            String query = "SELECT * FROM Vehiculo WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, matricula);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String marca = rs.getString("marca");
                        String modelo = rs.getString("modelo");
                        int year = rs.getInt("year");
                        Cliente titular = new ClienteDAO().getClienteDni(rs.getString("dni"));
                        vehiculo = new Vehiculo(matricula, marca, modelo, year, titular);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener vehiculo: " + e.getMessage());
            }
        }
        return null;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Vehiculo";
            try (Statement stmt = conexion.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String matricula = rs.getString("matricula");
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    int year = rs.getInt("year");
                    Cliente titular = new ClienteDAO().getClienteDni(rs.getString("dni"));
                    vehiculos.add(new Vehiculo(matricula, marca, modelo, year, titular));
                }
            } catch (SQLException e) {
                System.err.println("Error al listar vehiculos: " + e.getMessage());
                
            }
        }
        return null;
    }

    public void modificarMatriculaVehiculo(String matricula) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Vehiculo SET matricula = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, matricula);
                ps.setString(2, matricula);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar matricula: " + e.getMessage());
            }
        }
    }

    public void modificarMarcaVehiculo(String matricula, String marca) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Vehiculo SET marca = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, marca);
                ps.setString(2, matricula);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar marca: " + e.getMessage());
            }
        }
    }

    public void modificarModeloVehiculo(String matricula, String modelo) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Vehiculo SET modelo = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, modelo);
                ps.setString(2, matricula);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar modelo: " + e.getMessage());
            }
        }
    }

    public void modificarYearVehiculo(String matricula, int year) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Vehiculo SET year = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, year);
                ps.setString(2, matricula);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar año: " + e.getMessage());
            }
        }
    }

    public void modificarTitularVehiculo(String matricula, String dni) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Vehiculo SET dni = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, dni);
                ps.setString(2, matricula);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar titular: " + e.getMessage());
            }
        }
    }
}
