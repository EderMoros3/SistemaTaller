import java.util.Scanner;

import model.Empleado;
import view.CitaView;
import view.ClienteView;
import view.EmpleadoView;
import view.PiezaView;
import view.ServicioView;
import view.VehiculoView;
import view.PedidoView;

public class App {
    public static void main(String[] args) {
        ClienteView cliente = new ClienteView();
        CitaView cita = new CitaView();
        EmpleadoView empleado = new EmpleadoView();
        PiezaView pieza = new PiezaView();
        ServicioView servicio = new ServicioView();
        VehiculoView vehiculo = new VehiculoView();
        PedidoView pedido = new PedidoView();
        
        Scanner sc = new Scanner(System.in);
        Taller taller = new Taller();

        String usuario = "propietario";
        String passwd = "abadpayo";

        int opcion;
        int subOpcion;

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

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el usuario de administracion: ");
                    String usuarioEntrada = sc.nextLine();
                    sc.next();
                    System.out.println("Introduce la contraseña: ");
                    String passwdEntrada = sc.nextLine();
                    sc.next();

                    if (usuarioEntrada.equals(usuario) && passwdEntrada.equals(passwd)) {
                        System.out.println("Bienvenido administrador");
                        empleado.menuEmpleados();
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

                    switch (subOpcion) {
                        case 1 -> cliente.iniciarSesionCliente();
                        case 2 -> cliente.agregarCliente();
                        case 3 -> System.out.println("Saliendo del sistema...");
                    }
                }
            }
        } while (opcion != 3);
    }
}