package view;

import dao.PedidoDAO;
import java.util.Scanner;
import model.Pedido;
import model.Proveedor;

public class PedidoView {
    private Scanner sc = new Scanner(System.in);
    private PedidoDAO pedidoDAO = new PedidoDAO();

    private ProveedorView proveedorView = new ProveedorView();

    public void gestionPedidos() {
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
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> this.agregarPedido();
                case 2 -> this.modificarPedido();
                case 3 -> this.eliminarPedido();
                case 4 -> this.listarPedidos();
                case 5 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 5);
    }

    public void agregarPedido() {
        System.out.println("Agregar pedido");

        System.out.println("Introduce la fecha del pedido: ");
        String fechaPedido = sc.nextLine();
        System.out.println("Introduce la fecha de entrega: ");
        String fechaEntrega = sc.nextLine();
        System.out.println("Introduce el estado (true/false): ");
        Boolean estado = sc.nextBoolean();
        System.out.println("Introduce el precio: ");
        Double precio = sc.nextDouble();
        Proveedor proveedor = proveedorView.getProveedorId();
        Pedido pedido = new Pedido(fechaPedido, fechaEntrega, estado, precio, proveedor);
        pedidoDAO.insertarPedido(pedido);
        System.out.println("Pedido agregado correctamente");
    }

    public void eliminarPedido() {
        Pedido pedido = this.getPedidoID();
        pedidoDAO.eliminarPedido(pedido);
        System.out.println("Cliente eliminado correctamente");
    }

    public Pedido getPedidoID() {
        System.out.println("Introduce el ID del pedido: ");
        int idPedido = sc.nextInt();
        Pedido pedido = pedidoDAO.getIdPedido(idPedido);
        return pedido;
    }

    public void modificarPedido() {
        Pedido pedido = this.getPedidoID();
        int idPedido = pedido.getIdPedido();
        int opcion;

        do {
            System.out.println("Modificar pedido");
            System.out.println("1. Modificar fecha Pedido");
            System.out.println("2. Modificar fecha de Entrega");
            System.out.println("3. Modificar estado");
            System.out.println("4. Modificar precio");
            System.out.println("5. Modificar proveedor");
            System.out.println("6. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce la nueva fecha de pedido (DD-MM-YYYY): ");
                    String fecha = sc.nextLine();
                    sc.nextLine();
                    pedidoDAO.modificarFechaPedido(idPedido, fecha);
                    System.out.println("Fecha modificado correctamente");
                }
                case 2 -> {
                    System.out.println("Introduce la nueva fecha de entrega (DD-MM-YYYY): ");
                    String fecha = sc.nextLine();
                    sc.nextLine();
                    pedidoDAO.modifcarFechaEntregaPedido(idPedido, fecha);
                    System.out.println("Fecha de entrega modificado correctamente");
                }
                case 3 -> {
                    System.out.println("Introduce el nuevo estado (true/false): ");
                    Boolean estado = sc.nextBoolean();
                    pedidoDAO.modificarEstadoPedido(idPedido, estado);
                    System.out.println("Estado modificado correctamente");
                }
                case 4 -> {
                    System.out.println("Introduce el nuevo precio: ");
                    Double precio = sc.nextDouble();
                    pedidoDAO.modificarPrecioPedido(idPedido, precio);
                    System.out.println("Precio modificado correctamente");
                }
                case 5 -> {
                    Proveedor proveedor = proveedorView.getProveedorId();
                    pedidoDAO.modificarProveedorPedido(idPedido, proveedor.getIdProveedor());
                    System.out.println("Proveedor modificado correctamente");
                }
                case 6 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 6);
    }


    public void listarPedidos() {
        pedidoDAO.listarPedidos();
    }
}
