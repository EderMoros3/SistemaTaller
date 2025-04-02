package view;

import java.util.Scanner;

import dao.VehiculoDAO;
import model.Cliente;
import model.Vehiculo;

public class VehiculoView {
    private Scanner sc = new Scanner(System.in);
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private ClienteView clienteView = new ClienteView();

    public void gestionVehiculos() {
        int opcion;
        do {
            System.out.println("Gestion de vehiculos");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Listar vehiculos");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarVehiculo();
                case 2 -> this.modificarVehiculo();
                case 3 -> this.eliminarVehiculo();
                case 4 -> this.listarVehiculos();
                case 5 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 5);

    }

    public void agregarVehiculo() {
        System.out.println("Agregar vehiculo");
        System.out.println("Introduce la matricula: ");
        String matricula = sc.nextLine();
        sc.next();
        System.out.println("Introduce la marca: ");
        String marca = sc.nextLine();
        sc.next();
        System.out.println("Introduce el modelo: ");
        String modelo = sc.nextLine();
        sc.next();
        System.out.println("Introduce el año: ");
        int year = sc.nextInt();
        Cliente titular = clienteView.getClienteDni();
        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, year, titular);
        vehiculoDAO.insertarVehiculo(vehiculo);
        System.out.println("Vehiculo agregado correctamente");
    }

    public void eliminarVehiculo() {
        Vehiculo vehiculo = this.getVehiculoMatricula();
        vehiculoDAO.eliminarVehiculo(vehiculo);
        System.out.println("Vehiculo eliminado correctamente");
    }

    public Vehiculo getVehiculoMatricula() {
        System.out.println("Introduce la matricula del vehiculo: ");
        String matricula = sc.nextLine();
        sc.next();
        Vehiculo vehiculo = vehiculoDAO.getVehiculoMatricula(matricula);
        return vehiculo;
    }

    public void listarVehiculos() {
        vehiculoDAO.listarVehiculos();
    }

    public void modificarVehiculo() {
        Vehiculo vehiculo = this.getVehiculoMatricula();
        String matricula = vehiculo.getMatricula();
        System.out.println("Modificar vehiculo");
        System.out.println("1. Modificar matricula");
        System.out.println("2. Modificar marca");
        System.out.println("3. Modificar modelo");
        System.out.println("4. Modificar año");
        System.out.println("5. Modificar titular");
        System.out.println("6. Volver al menu anterior");
        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce la matricula: ");
                matricula = sc.nextLine();
                sc.next();
                vehiculoDAO.modificarMatriculaVehiculo(matricula);
                System.out.println("Matricula modificada correctamente");
            }
            case 2 -> {
                System.out.println("Introduce la marca: ");
                String marca = sc.nextLine();
                sc.next();
                vehiculoDAO.modificarMarcaVehiculo(matricula, marca);
                System.out.println("Marca modificada correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el modelo: ");
                String modelo = sc.nextLine();
                sc.next();
                vehiculoDAO.modificarModeloVehiculo(matricula, modelo);
                System.out.println("Modelo modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce el año: ");
                int year = sc.nextInt();
                vehiculoDAO.modificarYearVehiculo(matricula, year);
                System.out.println("Año modificado correctamente");
            }
            case 5 -> {
                Cliente titular = clienteView.getClienteDni();
                String dni = titular.getDni();
                vehiculoDAO.modificarTitularVehiculo(matricula, dni);
                System.out.println("Titular modificado correctamente");
            }
            case 6 -> System.out.println("Volviendo al menu anterior");
        }
    }

}
