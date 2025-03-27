package view;

import java.util.Scanner;

import dao.EmpleadoDAO;
import model.Empleado;

public class EmpleadoView {
    private Scanner sc = new Scanner(System.in);
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

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
                case 1 -> this.agregarEmpleado();
                case 2 -> this.modificarEmpleado();
                case 3 -> this.eliminarEmpleado();
                case 4 -> this.listarEmpleados();
                case 5 -> System.out.println("Volver al Menu Principal");
            }
        } while (opcion != 5);
    }

    public void agregarEmpleado() {
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
        Empleado empleado = empleadoDAO.getEmpleadoID();
        empleadoDAO.eliminarEmpleado(empleado);
        System.out.println("Empleado eliminado correctamente");
    }

    public void modificarEmpleado() {
        Empleado empleado = empleadoDAO.getEmpleadoID();
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
                empleadoDAO.modificarNombreEmpleado(nombre);
                System.out.println("Nombre modificado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el apellido: ");
                String apellido = sc.nextLine();
                sc.next();
                empleadoDAO.modificarApellidoEmpleado(apellido);
                System.out.println("Apellido modificado correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el ID: ");
                int id = sc.nextInt();
                empleadoDAO.modificarIdEmpleado(id);
                System.out.println("ID modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce el telefono: ");
                int telefono = sc.nextInt();
                empleadoDAO.modificarTlfEmpleado(telefono);
                System.out.println("Telefono modificado correctamente");
            }
            case 5 -> System.out.println("Volviendo a gestion de empleados");

        }
    }

    public void listarEmpleados() {
        empleadoDAO.listarEmpleados();
    }
}
