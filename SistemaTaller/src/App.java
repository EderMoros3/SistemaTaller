import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        Taller taller = new Taller();

        do {
            System.out.println("Bienvenido al taller: ");
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

        } while (opcion != 8);

        switch (opcion) {
            1 -> taller.gestionClientes();
            2 -> //gestionEmpleados();
            3 -> //gestionServicios();
            4 -> //gestionInvetario();
            5 -> //gestionPedidos();
            6 -> //gestionVehiculos();
            7 -> //gestionCitas();
            8 -> System.out.println("El programa se cerro");
        }
    }
}