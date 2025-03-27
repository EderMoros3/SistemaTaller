package view;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.VehiculoDAO;
import model.Cliente;
import model.Vehiculo;

public class VehiculoView {
    private Scanner sc = new Scanner(System.in);
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

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
                case 1 -> vehiculoDAO.agregarVehiculo();
                case 2 -> vehiculoDAO.modificarVehiculo();
                case 3 -> vehiculoDAO.eliminarVehiculo();
                case 4 -> vehiculoDAO.listarVehiculos();
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
        Cliente titular = clienteDAO.getClienteDni();
        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, year, titular);
        vehiculoDAO.listaVehiculos.add(vehiculo);
        System.out.println("Vehiculo agregado correctamente");
    }

    public void eliminarVehiculo() {
        Vehiculo vehiculo = vehiculoDAO.getVehiculoMatricula();
        vehiculoDAO.listaVehiculos.remove(vehiculo);
        System.out.println("Vehiculo eliminado correctamente");
    }

    public void listarVehiculos() {
        for (Vehiculo vehiculo : vehiculoDAO.listaVehiculos) {
            System.out.println(vehiculo);
        }
    }
}
