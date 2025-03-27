public class InsertarDB {
    public static void agregarCliente(String nombre, String apellido, int telefono, String direccion, String email) {
        Connection conn = ConexionDB.getConnection();
        if (conexion != null) {
            String query = "INSERT INTO Cliente (nombre, apellido, telefono, direccion, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setInt(3, telefono);
            statement.setString(4, direccion);
            statement.setString(5, email);
            statement.executeUpdate();
            System.out.println("Cliente agregado correctamente");
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        conecction.close();
        
        
    }

    public static void agregarEmpleado(String nombre, String apellido, int idEmpleado, int telefono) {
        Connection conn = ConexionDB.getConnection();
        if (conexion != null) {
            String query = "INSERT INTO Empleado (nombre, apellido, idEmpleado, telefono) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setInt(3, idEmpleado);
            statement.setInt(4, telefono);
            statement.executeUpdate();
            System.out.println("Empleado agregado correctamente");
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        conecction.close();
    }
}