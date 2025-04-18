package view;

import dao.ServicioDAO;


import java.util.ArrayList;
import java.util.Scanner;
import model.Servicio;

public class ServicioView {
    private Scanner sc = new Scanner(System.in);
    private ServicioDAO servicioDAO = new ServicioDAO();
    
    public void gestionServicios() {

        int opcion;
        do{
            System.out.println("Gestión de servicios");
            System.out.println("1. Agregar servicio");
            System.out.println("2. Modificar servicio");
            System.out.println("3. Eliminar servicio");
            System.out.println("4. Listar servicios");
            System.out.println("5. Volver al menú principal");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            
            switch (opcion) {
                case 1 -> this.agregarServicio();
                case 2 -> this.modificarServicio();
                case 3 -> this.eliminarServicio();
                case 4 -> this.listarServicios();
                case 5 -> System.out.println("Volviendo al menú principal");
            }
        } while (opcion != 5);

    }

    public void agregarServicio() {
        Double precio;

        System.out.println("Agregar servicio");
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        do {
            System.out.println("Introduce el precio: ");
            precio = sc.nextDouble();
        } while (precio < 0);
        
        Servicio servicio = new Servicio(nombre, precio);
        servicioDAO.insertarServicio(servicio);
        System.out.println("Servicio agregado correctamente");
    }

    public Servicio getServicioId() {
        System.out.println("Introduce el ID del servicio: ");
        int id = sc.nextInt();
        Servicio servicio = servicioDAO.getServicioID(id);
        return servicio;
    }

    public void eliminarServicio() {
        Servicio servicio = this.getServicioId();
        servicioDAO.eliminarServicio(servicio);
        System.out.println("Servicio eliminado correctamente");
    }

    public void listarServicios() {
        ArrayList<Servicio> listaServicios = servicioDAO.listarServicios();
        System.out.println("Lista de servicios: ");
        for (Servicio servicio : listaServicios) {
            System.out.println(servicio.toString());
        }

    }

    public void modificarServicio() {
        Servicio servicio = this.getServicioId();
        int idServicio = servicio.getIdServicio();
        int opcion;

        do {
            System.out.println("Modificar servicio");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar precio");
            System.out.println("3. Modificar id");
            System.out.println("4. Volver al menú principal");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nuevo nombre: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    servicioDAO.modificarNombreServicio(nombre, idServicio);
                    System.out.println("Nombre modificado correctamente");
                }
                case 2 -> {
                    Double precio;
                    do {
                        System.out.println("Introduce el nuevo precio: ");
                        precio = sc.nextDouble();
                    } while (precio < 0);
                    servicioDAO.modificarprecio(precio, idServicio);
                    System.out.println("Precio modificado correctamente");
                }
                case 3 -> {
                    int id;
                    do {
                        System.out.println("Introduce el nuevo id: ");
                        id = sc.nextInt();
                    } while (id < 0);
                    servicioDAO.modificarIdServicio(id, idServicio);
                    System.out.println("ID modificado correctamente");
                }
                case 4 -> System.out.println("Volviendo al menú anterior");
            }
        } while (opcion != 4);
}


    public void historialServiciosCliente() {
        System.out.println("Introduce el dni del cliente: ");
        String dni = sc.nextLine();
        sc.nextLine();

        ArrayList<Servicio> servicios = servicioDAO.historialServiciosCliente(dni);

        if (servicios == null || servicios.isEmpty()) {
            System.out.println("Error al listar servicios del cliente. Por favor, intente nuevamente.");
            return;
        }

        System.out.println("Historial de servicios del cliente con DNI: " + dni);
        for (Servicio servicio : servicios) {
            System.out.println(servicio.toString());
        }
    }
}
