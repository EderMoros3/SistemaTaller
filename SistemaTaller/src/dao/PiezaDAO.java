package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pieza;

public class PiezaDAO {
    public void insertarPieza(Pieza pieza) {
        String referencia = pieza.getReferencia();
        String nombre = pieza.getNombre();
        String marca = pieza.getMarca();
        String descripcion = pieza.getDescripcion();
        Double precio = pieza.getPrecio();
        int cantidad = pieza.getCantidad();
        int idPieza = pieza.getIdPieza();
        

        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Pieza (referencia, nombre, marca, descripcion, precio, cantidad, idPieza) VALUES ( ?, ?, ? ,?, ?, ?, ?)";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, referencia);
                ps.setString(2, nombre);
                ps.setString(3, marca);
                ps.setString(4, descripcion);
                ps.setDouble(5, precio);
                ps.setInt(6, cantidad);
                ps.setInt(7, idPieza);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("Error al insertar pieza: " + e.getMessage());
            }
        
        
        
        }
    }

    public void eliminarPieza(Pieza pieza) {
        int idPieza = pieza.getIdPieza();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Pieza WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar pieza: " + e.getMessage());
                
            }
        }
    }
    
    public Pieza getIdPieza(int idPieza) {
        Connection conexion = ConexionDB.conectar();
        Pieza pieza = null;

        if (conexion != null) {
            String query = "SELECT * FROM Pieza WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPieza);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String referencia = rs.getString("referencia");
                        String nombre = rs.getString("nombre");
                        String marca = rs.getString("marca");
                        String descripcion = rs.getString("descripcion");
                        Double precio = rs.getDouble("precio");
                        int cantidad = rs.getInt("cantidad");

                        pieza = new Pieza(referencia, nombre, marca, descripcion, precio, cantidad);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener cliente por DNI: " + e.getMessage());
            }
        }
        return pieza;
    }

    public void modificarReferenciaPieza(String referencia, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET referencia = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, referencia);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar referencia de Pieza: " + e.getMessage());
            }
        }
    }

    public void actualizarNombrePieza(String nombre, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET nombre = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar nombre de Pieza: " + e.getMessage());
            }
        }
    }

    public void modificarMarcaPieza(String marca, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET marca = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, marca);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar marca de Pieza: " + e.getMessage());
            }
        }
    }

    public void modificarDescPieza(String descripcion, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET descripcion = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, descripcion);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar descripcion de Pieza: " + e.getMessage());
            }
        }
    }

    public void modificarPrecioPieza(Double precio, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET precio = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setDouble(1, precio);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar precio de Pieza: " + e.getMessage());
            }
        }
    }

    public void modificarCantidadPieza(int cantidad, int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET cantidad = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setDouble(1, cantidad);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar cantidad de Pieza: " + e.getMessage());
            }
        }
    }

    public void actualizarIdPieza(int idPieza) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pieza SET idPieza = ? WHERE idPieza = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPieza);
                ps.setInt(2, idPieza);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar idPieza de Pieza: " + e.getMessage());
            }
        }
    }
    
    public ArrayList<Pieza> listarPiezas() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Pieza> piezas = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Pieza";

            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int idPieza = rs.getInt("idPieza");
                    String referencia = rs.getString("referencia");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    String descripcion = rs.getString("descripcion");
                    Double precio = rs.getDouble("precio");
                    int cantidad = rs.getInt("cantidad");
                    

                    Pieza pieza = new Pieza(referencia, nombre, marca, descripcion, precio, cantidad);
                    pieza.setIdPieza(idPieza);
                    piezas.add(pieza);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar piezas: " + e.getMessage());
            }
        return piezas;
        }
        return null;
    }


}
