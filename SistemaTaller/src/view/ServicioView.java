package view;

import java.util.Scanner;
import model.Servicio;
import dao.ServicioDAO;

public class ServicioView {
    private Scanner sc = new Scanner(System.in);
    private ServicioDAO servicioDAO = new ServicioDAO();
    
    public void gestionServicios() {

        int opcion;
        do
        System.out.println("Gestión de servicios");
        System.out.println("1. Agregar servicio");
        System.out.println("2. Modificar servicio");
        System.out.println("3. Eliminar servicio");
        System.out.println("4. Listar servicios");
        System.out.println("5. Volver al menú principal");
        System.out.println("Ingrese una opción: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> this.agregarServicio();
            case 2 -> this.modificarServicio();
            case 3 -> this.eliminarServicio();
            case 4 -> this.listarServicios();
            case 5 -> System.out.println("Volviendo al menú principal");
        }
        while (opcion != 5);
    }

    public void agregarServicio() {
        Double precio;

        System.out.println("Agregar servicio");
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        sc.next();
        do {
            System.out.println("Introduce el precio: ");
            precio = sc.nextDouble();
        } while (precio < 0);
        
        Servicio servicio = new Servicio(nombre, precio);
        servicioDAO.insertarServicio(servicio);
        System.out.println("Servicio agregado correctamente");
    }

    public void eliminarServicio() {
        Servicio servicio = servicioDAO.getServicioID();
        servicioDAO.eliminarServicio(servicio);
        System.out.println("Servicio eliminado correctamente");
    }

    public void listarServicios() {
        servicioDAO.listarServicios();
    }

    public void modificarServicio() {
        int opcion;

        do {
            System.out.println("Modificar servicio");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar precio");
            System.out.println("3. Modificar id");
            System.out.println("4. Volver al menú principal");
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nuevo nombre: ");
                    String nombre = sc.nextLine();
                    sc.next();
                    servicioDAO.modificarNombreServicio(nombre);
                    System.out.println("Nombre modificado correctamente");
                }
                case 2 -> {
                    Double precio;
                    do {
                        System.out.println("Introduce el nuevo precio: ");
                        precio = sc.nextDouble();
                    } while (precio < 0);
                    servicioDAO.modificarPrecioServicio(precio);
                    System.out.println("Precio modificado correctamente");
                }
                case 3 -> {
                    int id;
                    do {
                        System.out.println("Introduce el nuevo id: ");
                        id = sc.nextInt();
                    } while (id < 0);
                    servicioDAO.modificarIdServicio(id);
                    System.out.println("ID modificado correctamente");
                }
                case 4 -> System.out.println("Volviendo al menú anterior");
            }
        } while (opcion != 4);
    }
}
