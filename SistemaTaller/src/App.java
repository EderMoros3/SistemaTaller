import dao.ConexionDB;
import java.sql.Connection;
import java.util.Scanner;
import view.CitaView;
import view.ClienteView;
import view.EmpleadoView;
public class App {
    public static void main(String[] args) {
        Connection conexion = ConexionDB.conectar();
        ClienteView cliente = new ClienteView();
        CitaView cita = new CitaView();

        // Establecer las dependencias
        cliente.setCitaView(cita);
        cita.setClienteView(cliente);

        EmpleadoView empleado = new EmpleadoView();
        Scanner sc = new Scanner(System.in);

        String usuario = "admin";
        String passwd = "abadpayo";

        int opcion;
        int subOpcion;
        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
        // TODO: Login para verificar admin o usuario normal
        // TODO: Actualizar tablas de la base de datos
        // TODO: Fix de cosas
        // TODO: Mejorar consultas sql (ej: subconsultas, joins, etc)
        
        do {
            System.out.println("Bienvenido al taller: ");
            System.out.println("----------------------------");
            System.out.println("1. Iniciar sesion como administrador");
            System.out.println("2. Iniciar sesion como cliente");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer después de leer un entero

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el usuario de administracion: ");
                    String usuarioEntrada = sc.nextLine();
                    System.out.println("Introduce la contraseña: ");
                    String passwdEntrada = sc.nextLine();

                    if (usuarioEntrada.equals(usuario) && passwdEntrada.equals(passwd)) {
                        System.out.println("Bienvenido administrador");
                        empleado.menuEmpleado();
                    } else {
                        System.out.println("Usuario o contraseña incorrectos");
                    }
                }
                case 2 -> {
                    System.out.println("Bienvenido al taller como cliente");
                    System.out.println("1. Iniciar sesion");
                    System.out.println("2. Registrarse como cliente");
                    System.out.println("3. Salir");
                    System.out.println("Selecciona una opcion: ");
                    subOpcion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer después de leer un entero

                    switch (subOpcion) {
                        case 1 -> cliente.iniciarSesionCliente();
                        case 2 -> cliente.agregarCliente();
                        case 3 -> System.out.println("Saliendo del sistema...");
                    }
                }
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 3);
    }
}