package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

import model.Vehiculo;

public class VehiculoDAO {
    public void insertarVehiculo(Vehiculo vehiculo) {
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int year = vehiculo.getYear();
        String dni = cliente.getDni();
        
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "INSERT INTO Vehiculo (matricula, marca, modelo, year) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, matricula);
                ps.setString(2, marca);
                ps.setString(3, modelo);
                ps.setInt(4, year);
                ps.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error al insertar vehiculo: " + e.getMessage());
            }
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        // DELETE SQL
    }

    public Vehiculo getVehiculoMatricula() {
        // SELECT SQL
        return null;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        // SELECT SQL
        return null;
    }

    public void moficiarMatriculaVehiculo(String matricula) {
        // UPDATE SQL
    }

    public void modificarMarcaVehiculo(String marca) {
        // UPDATE SQL
    }

    public void modificarModeloVehiculo(String modelo) {
        // UPDATE SQL
    }

    public void modificarYearVehiculo(int year) {
        // UPDATE SQL
    }

    public void modificarTitularVehiculo(String dni) {
        // UPDATE SQL
    }
}
