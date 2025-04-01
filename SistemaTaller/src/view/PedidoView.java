package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.PedidoDAO;
import model.Pedido;

public class PedidoView {
    private Scanner sc = new Scanner(System.in);
    private PedidoDAO pedidoDAO = new PedidoDAO();

    private void gestionPedidos(); {
        int opcion;
        do {
            System.out.println("\nGestion de pedidos");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Modificar pedido");
            System.out.println("3. Eliminar pedido");
            System.out.println("4. Listar pedidos");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarPedido();
                case 2 -> this.modificarPedido();
                case 3 -> this.eliminarPedido();
                case 4 -> this.listarPedidos();
                case 5 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 5);
    }


}
