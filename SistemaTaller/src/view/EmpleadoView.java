package view;

import dao.EmpleadoDAO;
import java.util.Scanner;
import model.Empleado;

public class EmpleadoView {
    private Scanner sc = new Scanner(System.in);
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private ClienteView cliente = new ClienteView();
    private CitaView cita = new CitaView();
    private PiezaView pieza = new PiezaView();
    private ServicioView servicio = new ServicioView();
    private VehiculoView vehiculo = new VehiculoView();
    private PedidoView pedido = new PedidoView();
    

    public void menuEmpleado() {
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
                case 2 -> this.gestionEmpleados();
                case 3 -> servicio.gestionServicios(); 
                case 4 -> pieza.gestionInvetario(); 
                case 5 -> pedido.gestionPedidos();
                case 6 -> vehiculo.gestionVehiculos();
                case 7 -> cita.gestionCitas();
                case 8 -> System.out.println("El programa se cerro");
            }
        } while (opcion != 8);
    }

    public void gestionEmpleados() {
        int opcion;
        do {
            System.out.println("Gestion empleados");
            System.out.println("---------------------");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Volver al Menu Principal");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarEmpleados();
                case 2 -> this.modificarEmpleado();
                case 3 -> this.eliminarEmpleado();
                case 4 -> this.listarEmpleados();
                case 5 -> System.out.println("Volver al Menu Principal");
            }
        } while (opcion != 5);
    }

    public void agregarEmpleados() {
        System.out.println("Agregar empleado");
        System.out.println("-----------------------");
        System.out.println("Ingrese el nombre del empleado");
        String nombre = sc.nextLine();
        sc.next();

        System.out.println("Ingrese el apellido del empleado");
        String apellido = sc.nextLine();
        sc.next();

        System.out.println("Ingrese el ID del empleado");
        int idEmpleado = sc.nextInt();

        System.out.println("Ingrese el telefono del empleado");
        int telefono = sc.nextInt();

        Empleado empleado = new Empleado(nombre, apellido, idEmpleado, telefono);
        empleadoDAO.insertarEmpleado(empleado);
        System.out.println("Empleado agregado correctamente");
    }

    public void eliminarEmpleado() {
        Empleado empleado = this.getEmpleadoID();
        empleadoDAO.eliminarEmpleado(empleado);
        System.out.println("Empleado eliminado correctamente");
    }

    public Empleado getEmpleadoID() {
        System.out.println("Introduzca el ID del empleado: ");
        int idEmpleado = sc.nextInt();
        Empleado empleado = empleadoDAO.getIdEmpleado(idEmpleado);
        return empleado;
    }

    public void modificarEmpleado() {
        Empleado empleado = this.getEmpleadoID();
        int idEmpleado = empleado.getIdEmpleado();

        int opcion;

        do {
            System.out.println("Modificar Empleado");
            System.out.println("-----------------------");
            System.out.println("1. Modificar nombre del empleado");
            System.out.println("2. Modificar apellido del empleado");
            System.out.println("3. Modificar ID del Empleado");
            System.out.println("4. Modificar telefono del Empleado");
            System.out.println("5. Volver a Gestion Empleados");
            opcion = sc.nextInt();

        } while (opcion != 5);

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre: ");
                String nombre = sc.nextLine();
                sc.next();
                empleadoDAO.modificarNombreEmpleado(nombre, idEmpleado);
                System.out.println("Nombre modificado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el apellido: ");
                String apellido = sc.nextLine();
                sc.next();
                empleadoDAO.modificarApellidoEmpleado(apellido, idEmpleado);
                System.out.println("Apellido modificado correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el ID nuevo: ");
                int id = sc.nextInt();
                empleadoDAO.modificarIdEmpleado(id, idEmpleado);
                System.out.println("ID modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce el telefono: ");
                int telefono = sc.nextInt();
                empleadoDAO.modificarTlfEmpleado(telefono, idEmpleado);
                System.out.println("Telefono modificado correctamente");
            }
            case 5 -> System.out.println("Volviendo a gestion de empleados");

        }
    }

    public void listarEmpleados() {
        empleadoDAO.listarEmpleados();
    }
}
