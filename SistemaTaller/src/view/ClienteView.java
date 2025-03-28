package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteView {
    private Scanner sc = new Scanner(System.in);
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void gestionClientes() {

        int opcion;
        do {
            System.out.println("\nGestion de clientes");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarCliente();
                case 2 -> this.modificarCliente();
                case 3 -> this.eliminarCliente();
                case 4 -> this.listarClientes();
                case 5 -> System.out.println("Volviendo al menu principal");
            }
        } while (opcion != 5);
    }

    public void agregarCliente() {
        System.out.println("Agregar cliente");
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        sc.next();
        System.out.println("Introduce el apellido: ");
        String apellido = sc.nextLine();
        sc.next();
        System.out.println("Introduce el telefono: ");
        int telefono = sc.nextInt();
        System.out.println("Introduce la direccion: ");
        String direccion = sc.nextLine();
        sc.next();
        System.out.println("Introduce el email: ");
        String email = sc.nextLine();
        sc.next();
        System.out.println("Introduce el dni: ");
        String dni = sc.nextLine();
        sc.next();

        Cliente cliente = new Cliente(nombre, apellido, telefono, direccion, email, dni);
        clienteDAO.insertarCliente(cliente);
        System.out.println("Cliente agregado correctamente");
    }

    public void eliminarCliente() {
        Cliente cliente = this.getClienteDni();
        clienteDAO.eliminarCliente(cliente);
        System.out.println("Cliente eliminado correctamente");
    }

    public Cliente getClienteDni() {
        System.out.println("Introduce el dni del cliente: ");
        String dni = sc.nextLine();
        sc.next();
        Cliente cliente = clienteDAO.getClienteDni(dni);
        return cliente;
    }

    public void modificarCliente() {
        Cliente cliente = this.getClienteDni();
        String dni = cliente.getDni();
        int opcion;
        do {
            System.out.println("Modificar cliente");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar apellido");
            System.out.println("3. Modificar telefono");
            System.out.println("4. Modificar direccion");
            System.out.println("5. Modificar email");
            System.out.println("6. Modificar dni");
            System.out.println("7. Volver al menu anterior");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
        } while (opcion != 7);

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre: ");
                String nombre = sc.nextLine();
                sc.next();
                clienteDAO.actualizarNombreCliente(dni, nombre);
                System.out.println("Nombre modificado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el apellido: ");
                String apellido = sc.nextLine();
                sc.next();
                clienteDAO.actualizarApellidoCliente(apellido);
                System.out.println("Apellido modificado correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el telefono: ");
                int telefono = sc.nextInt();
                clienteDAO.actualizarTlfCliente(telefono);
                System.out.println("Telefono modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce la direccion: ");
                String direccion = sc.nextLine();
                sc.next();
                clienteDAO.actualizarDireccionCliente(direccion);
                System.out.println("Direccion modificada correctamente");
            }
            case 5 -> {
                System.out.println("Introduce el email: ");
                String email = sc.nextLine();
                sc.next();
                clienteDAO.actualizarEmailCliente(email);
                System.out.println("Email modificado correctamente");
            }
            case 6 -> {
                System.out.println("Introduce el dni: ");
                String dni = sc.nextLine();
                sc.next();
                clienteDAO.actualizarDniCliente(dni);
                System.out.println("Dni modificado correctamente");
            }
            case 7 -> System.out.println("Volviendo al menu anterior");
        }

    }

    public void listarClientes() {
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
    }
}