package view;

import dao.PiezaDAO;
import java.util.Scanner;
import model.Pieza;

public class PiezaView {
    private Scanner sc = new Scanner(System.in);
    private PiezaDAO piezaDAO = new PiezaDAO();

    public void gestionInvetario() {
        int opcion;
        do {
            System.out.println("Gestion de inventario");
            System.out.println("1. Agregar pieza");
            System.out.println("2. Modificar pieza");
            System.out.println("3. Eliminar pieza");
            System.out.println("4. Listar piezas");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarPieza();
                case 2 -> this.modificarPieza();
                case 3 -> this.eliminarPieza();
                case 4 -> this.listarPiezas();
                case 5 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 5);
    }

    public void agregarPieza() {
        Double precioPieza;
        int cantidad;

        System.out.println("Agregar pieza");
        System.out.println("Introduce la referencia: ");
        String referencia = sc.nextLine();
        sc.next();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        sc.next();
        System.out.println("Introduce la marca: ");
        String marca = sc.nextLine();
        sc.next();
        System.out.println("Introduce la descripcion: ");
        String descripcion = sc.nextLine();
        sc.next();

        do {
            System.out.println("Introduce el precio: ");
            precioPieza = sc.nextDouble();
        } while (precioPieza < 0);

        do {
            System.out.println("Introduce la cantidad: ");
            cantidad = sc.nextInt();
        } while (cantidad < 0);
        
        Pieza pieza = new Pieza(referencia, nombre, marca, descripcion, precioPieza, cantidad);
        piezaDAO.insertarPieza(pieza);
        System.out.println("Pieza agregada correctamente");
    }

    public Pieza getIdPieza() {
        System.out.println("Introduzca el Id de la pieza: ");
        int idPieza = sc.nextInt();
        return piezaDAO.getIdPieza(idPieza);
    }

    public void eliminarPieza() {
        Pieza pieza = this.getIdPieza();
        piezaDAO.eliminarPieza(pieza);
        System.out.println("Pieza eliminada correctamente");
    }

    public void listarPiezas() {
        piezaDAO.listarPiezas();
    }

    public void modificarPieza() {
        System.out.println("Modificar pieza");
        Pieza pieza = this.getIdPieza();
        int idPieza = pieza.getIdPieza();
        int opcion;
        do {
            System.out.println("1. Modificar referencia");
            System.out.println("2. Modificar marca");
            System.out.println("3. Modificar descripcion");
            System.out.println("4. Modificar precio");
            System.out.println("5. Modificar cantidad");
            System.out.println("6. Volver al menu anterior");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
        } while (opcion != 6);

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce la referencia: ");
                String referencia = sc.nextLine();
                sc.next();
                piezaDAO.modificarReferenciaPieza(referencia, idPieza);
                System.out.println("Referencia modificada correctamente");
            }

            case 2 -> {
                System.out.println("Introduce la marca: ");
                String marca = sc.nextLine();
                sc.next();
                piezaDAO.modificarMarcaPieza(marca, idPieza);
                System.out.println("Marca modificada correctamente");
            }

            case 3 -> {
                System.out.println("Introduce la descripcion: ");
                String descripcion = sc.nextLine();
                sc.next();
                piezaDAO.modificarDescPieza(descripcion, idPieza);
                System.out.println("Descripcion modificada correctamente");
            }

            case 4 -> {
                Double precioPieza;
                do {
                    System.out.println("Introduce el precio: ");
                    precioPieza = sc.nextDouble();
                } while (precioPieza < 0);
                piezaDAO.modificarPrecioPieza(precioPieza, idPieza);
                System.out.println("Precio modificado correctamente");
            }

            case 5 -> {
                int cantidad;
                do {
                    System.out.println("Introduce la cantidad: ");
                    cantidad = sc.nextInt();
                } while (cantidad < 0);
                piezaDAO.modificarCantidadPieza(cantidad, idPieza);
                System.out.println("Cantidad modificada correctamente");
            }

            case 6 -> System.out.println("Volviendo al menu anterior");
        }

    }

}
