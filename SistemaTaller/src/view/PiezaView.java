package view;

import java.util.Scanner;

import dao.PiezaDAO;
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
        
        Pieza pieza = new Pieza(referencia, marca, descripcion, precioPieza, cantidad);
        piezaDAO.insertarPieza(pieza);
        System.out.println("Pieza agregada correctamente");
    }

    public void eliminarPieza() {
        Pieza pieza = piezaDAO.getPiezaReferencia();
        piezaDAO.eliminarPieza(pieza);
        System.out.println("Pieza eliminada correctamente");
    }

    public void listarPiezas() {
        piezaDAO.listarPiezas();
    }

    public void modificarPieza() {
        System.out.println("Modificar pieza");
        Pieza pieza = piezaDAO.getPiezaReferencia();
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
                piezaDAO.modificarRefPieza(referencia);
                System.out.println("Referencia modificada correctamente");
            }

            case 2 -> {
                System.out.println("Introduce la marca: ");
                String marca = sc.nextLine();
                sc.next();
                piezaDAO.moficarMarcaPieza(marca);
                System.out.println("Marca modificada correctamente");
            }

            case 3 -> {
                System.out.println("Introduce la descripcion: ");
                String descripcion = sc.nextLine();
                sc.next();
                piezaDAO.moficiarDescPieza(descripcion);
                System.out.println("Descripcion modificada correctamente");
            }

            case 4 -> {
                Double precioPieza;
                do {
                    System.out.println("Introduce el precio: ");
                    precioPieza = sc.nextDouble();
                } while (precioPieza < 0);
                piezaDAO.modificarPrecioPieza(precioPieza);
                System.out.println("Precio modificado correctamente");
            }

            case 5 -> {
                int cantidad;
                do {
                    System.out.println("Introduce la cantidad: ");
                    cantidad = sc.nextInt();
                } while (cantidad < 0);
                piezaDAO.modificarCantPieza(cantidad);
                System.out.println("Cantidad modificada correctamente");
            }

            case 6 -> System.out.println("Volviendo al menu anterior");
        }

    }

}
