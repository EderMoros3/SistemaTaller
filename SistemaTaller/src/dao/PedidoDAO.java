package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pedido;
import model.Proveedor;

public class PedidoDAO {
    public void insertarPedido(Pedido pedido) {
        int idPedido = pedido.getIdPedido();
        String fechaPedido = pedido.getFechaPedido();
        String fechaEntrega = pedido.getFechaEntrega();
        Boolean estado = pedido.getEstado();
        Double precio = pedido.getPrecio();
        int idProveedor = pedido.getProveedor().getIdProveedor(); // Asumiendo que el proveedor tiene un método getDni()

        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            String query = "INSERT INTO Pedido (idPedido, fechaPedido, fechaEntrega, estado, precio, idProveedor) VALUES ( ?, ?, ? ,?, ?, ?)";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPedido);
                ps.setString(2, fechaPedido);
                ps.setString(3, fechaEntrega);
                ps.setBoolean(4, estado);
                ps.setDouble(5, precio);
                ps.setInt(6, idProveedor);
                ps.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("Error al insertar pedido: " + e.getMessage());
            }
        
        
        
        }
    }

    public void eliminarPedido(Pedido pedido) {
        int idPedido = pedido.getIdPedido();

        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "DELETE FROM Pedido WHERE idPedido = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPedido);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar pedido: " + e.getMessage());
                
            }
        }
    }

    public ArrayList<Pedido> listarPedidos() {
        Connection conexion = ConexionDB.conectar();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        if (conexion != null) {
            String query = "SELECT * FROM Pedido";

            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int idPedido = rs.getInt("idPedido");
                    String fechaPedido = rs.getString("fechaPedido");
                    String fechaEntrega = rs.getString("fechaEntrega");
                    Boolean estado = rs.getBoolean("estado");
                    Double precio = rs.getDouble("precio");
                    Proveedor proveedor = new ProveedorDAO().getProveedorID(rs.getInt("idProveedor"));
                    

                    Pedido pedido = new Pedido(fechaPedido, fechaEntrega, estado, precio, proveedor);
                    pedidos.add(pedido);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar pedidos: " + e.getMessage());
            }
        return pedidos;
        }
        return null;
    }

    public Pedido getIdPedido(int idPedido) {
        Connection conexion = ConexionDB.conectar();
        Pedido pedido = null;

        if (conexion != null) {
            String query = "SELECT * FROM Pedido WHERE idPedido = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setInt(1, idPedido);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String fechaPedido = rs.getString("fechaPedido");
                        String fechaEntrega = rs.getString("fechaEntrega");
                        Boolean estado = rs.getBoolean("estado");
                        Double precio = rs.getDouble("precio");
                        Proveedor proveedor = new ProveedorDAO().getProveedorID(rs.getInt("idProveedor"));
                        

                        pedido = new Pedido(fechaPedido, fechaEntrega, estado, precio, proveedor);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener pedido por ID: " + e.getMessage());
            }
        }
        return pedido;
    }

    public void modificarFechaPedido(int idPedido, String fechaPedido) {
        Connection conexion = ConexionDB.conectar();

        if (conexion != null) {
            String query = "UPDATE Pedido SET fechaPedido = ? WHERE idPedido = ?";

            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, fechaPedido);
                ps.setInt(2, idPedido);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar fecha del Pedido: " + e.getMessage());
            }
        }
    }

    public void modifcarFechaEntregaPedido(int idPedido,String fechaEntrega) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Pedido SET fechaEntrega = ? WHERE idPedido = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setString(1, fechaEntrega);
                stmt.setInt(2, idPedido);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar fecha de entrega del Pedido: " + e.getMessage());
            }
        }
    }

    public void modificarEstadoPedido(int idPedido, Boolean estado) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Pedido SET estado = ? WHERE idPedido = ? AND fechaEntrega IS NOT NULL";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setBoolean(1, estado);
                stmt.setInt(2, idPedido);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar estado del pedido: " + e.getMessage());
            }
        }
    }

    public void modificarPrecioPedido(int idPedido, Double precio) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Pedido SET Precio = ? WHERE idPedido = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setDouble(1, precio);
                stmt.setInt(2, idPedido);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar precio del pedido: " + e.getMessage());
            }
        }
    }

    public void modificarProveedorPedido(int idPedido, int idProveedor) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
            String query = "UPDATE Pedido SET idProveedor = ? WHERE idPedido = ?";
            try(PreparedStatement stmt = conexion.prepareStatement(query)){
                stmt.setInt(1, idProveedor);
                stmt.setInt(2, idPedido);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al modificar Proveedor del Pedido: " + e.getMessage());
            }
        }
    }

}