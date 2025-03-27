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
                case 1 -> piezaDAO.agregarPieza();
                case 2 -> piezaDAO.modificarPieza();
                case 3 -> piezaDAO.eliminarPieza();
                case 4 -> piezaDAO.listarPiezas();
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
        piezaDAO.listaPiezas.add(pieza);
        System.out.println("Pieza agregada correctamente");
    }

    public void eliminarPieza() {
        Pieza pieza = piezaDAO.getPiezaReferencia();
        piezaDAO.listaPiezas.remove(pieza);
        System.out.println("Pieza eliminada correctamente");
    }

    public void listarPiezas() {
        for (Pieza pieza : piezaDAO.listaPiezas) {
            System.out.println(pieza);
        }
    }
}
