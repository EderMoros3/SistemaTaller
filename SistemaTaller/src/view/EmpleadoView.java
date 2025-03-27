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
            System.out.println("4. Listar asignaciones de un empleado por ID");
            System.out.println("5. Volver al Menu Principal");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> empleadoDAO.agregarEmpleado();
                case 2 -> empleadoDAO.modificarEmpleado();
                case 3 -> empleadoDAO.eliminarEmpleado();
                case 4 -> empleadoDAO.listarAsignaciones();
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
        empleadoDAO.listaEmpleados.add(empleado);
        System.out.println("Empleado agregado correctamente");
    }

    public void eliminarEmpleado() {
        Empleado empleado = empleadoDAO.getEmpleadoID();
        empleadoDAO.listaEmpleados.remove(empleado);
        System.out.println("Empleado eliminado correctamente");
    }
}
