import java.util.Scanner;

import model.Empleado;
import view.CitaView;
import view.ClienteView;
import view.EmpleadoView;
import view.PiezaView;
import view.ServicioView;
import view.VehiculoView;

public class App {
    public static void main(String[] args) {
        ClienteView cliente = new ClienteView();
        CitaView cita = new CitaView();
        EmpleadoView empleado = new EmpleadoView();
        PiezaView pieza = new PiezaView();
        ServicioView servicio = new ServicioView();
        VehiculoView vehiculo = new VehiculoView();
        
        Scanner sc = new Scanner(System.in);
        Taller taller = new Taller();
        int opcion;

        do {
            System.out.println("\nBienvenido al taller: ");
            System.out.println("----------------------------");
            System.out.println("1. Gestion de clientes");
            System.out.println("2. Gestion de empleados");
            System.out.println("3. Gestion de servicios");
            System.out.println("4. Gestion de invetario: ");
            System.out.println("5. Gestion de pedidos: ");
            System.out.println("6. Gestion de vehiculos");
            System.out.println("7. Gestion de citas");
            System.out.println("8. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> cliente.gestionClientes();
                case 2 -> empleado.gestionEmpleados();
                case 3 -> servicio.gestionServicios(); // asignaciones
                case 4 -> pieza.gestionInvetario(); // provedores
                case 5 -> pedido.gestionPedidos();
                case 6 -> vehiculo.gestionVehiculos();
                case 7 -> cita.gestionCitas();
                case 8 -> System.out.println("El programa se cerro");
            }
        } while (opcion != 8);


    }
}