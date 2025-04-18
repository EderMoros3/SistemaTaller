package view;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {
    private Scanner sc = new Scanner(System.in);
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private CitaView citas;
    private ServicioView servicios = new ServicioView();

    public ClienteView() {}

    // Método para establecer la dependencia de CitaView
    public void setCitaView(CitaView citas) {
        this.citas = citas;
    }

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
            sc.nextLine();
    
            switch (opcion) {
                case 1 -> this.agregarCliente();
                case 2 -> this.modificarCliente();
                case 3 -> this.eliminarCliente();
                case 4 -> this.listarClientes();
                case 5 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public Cliente iniciarSesionCliente() {
        System.out.println("Iniciar sesion como cliente");
        Cliente cliente = this.getClienteDni();
        if (cliente == null) {
            System.out.println("El cliente no existe. Por favor, intente nuevamente.");
            return null;
        }
        menuCliente(cliente);
        return cliente;
        
    }

    public void menuCliente(Cliente cliente) {

        System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApellido());
        int opcion;
        do {
            System.out.println("Menu cliente");
            System.out.println("1. Modificar datos personales");
            System.out.println("2. Citas");
            System.out.println("3. Ver historial de servicios");
            System.out.println("4. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
    
            
            switch (opcion) {
                case 1 -> this.modificarCliente();
                case 2 -> citas.menuCitasCliente();
                case 3 -> servicios.historialServiciosCliente();
                case 4 -> System.out.println("Volviendo al menu principal");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    
    public void agregarCliente() {
        System.out.println("Agregar cliente");
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce el apellido: ");
        String apellido = sc.nextLine();
        sc.nextLine();
        int telefono;
        do {
            System.out.println("Introduce el telefono: ");
            telefono = sc.nextInt();
            sc.nextLine();
            if (clienteDAO.existeTelefono(telefono)) {
                System.out.println("El telefono ya está registrado. Intente con otro.");
            }
        } while (clienteDAO.existeTelefono(telefono));

        System.out.println("Introduce la direccion: ");
        String direccion = sc.nextLine();
        sc.nextLine();
        String email;
        do { 
            System.out.println("Introduce el email: ");
            email = sc.nextLine();
            sc.nextLine();
            if (clienteDAO.existeEmail(email)) {
                System.out.println("El email ya está registrado. Intente con otro.");
            }
        } while (clienteDAO.existeEmail(email));

        String dni;
        do {
            System.out.println("Introduce el dni: ");
            dni = sc.nextLine();
            sc.nextLine();
            if (clienteDAO.existeDni(dni)) {
                System.out.println("El DNI ya está registrado. Intente con otro.");
            }
        } while (clienteDAO.existeDni(dni));

        Cliente cliente = new Cliente(nombre, apellido, telefono, direccion, email, dni);
        clienteDAO.insertarCliente(cliente);
        clientes.add(cliente);
        System.out.println("Cliente creado correctamente");
    }

    public void eliminarCliente() {
        Cliente cliente = this.getClienteDni();
        clienteDAO.eliminarCliente(cliente);
        if (clienteDAO.existeDni(cliente.getDni())) {
            System.out.println("Error al eliminar el cliente. Por favor, intente nuevamente.");
            return;
            
        }
        System.out.println("Cliente eliminado correctamente");
    }

    public Cliente getClienteDni() {
        System.out.println("Introduce el dni del cliente: ");
        String dni = sc.nextLine();
        sc.nextLine();
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
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nombre: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    clienteDAO.actualizarNombreCliente(dni, nombre);
                    System.out.println("Nombre modificado correctamente");
                }
                case 2 -> {
                    System.out.println("Introduce el apellido: ");
                    String apellido = sc.nextLine();
                    sc.nextLine();
                    clienteDAO.actualizarApellidoCliente(dni, apellido);
                    System.out.println("Apellido modificado correctamente");
                }
                case 3 -> {
                    int telefono;
                    do {
                        System.out.println("Introduce el telefono: ");
                        telefono = sc.nextInt();
                        sc.nextLine();
                    if (clienteDAO.existeTelefono(telefono)) {
                        System.out.println("El telefono ya está registrado. Intente con otro.");
                    }
                    } while (clienteDAO.existeTelefono(telefono));
                    clienteDAO.actualizarTlfCliente(dni, telefono);
                    System.out.println("Telefono modificado correctamente");
                }
                case 4 -> {
                    System.out.println("Introduce la direccion: ");
                    String direccion = sc.nextLine();
                    sc.nextLine();
                    clienteDAO.actualizarDireccionCliente(dni, direccion);
                    System.out.println("Direccion modificada correctamente");
                }
                case 5 -> {
                    String email;
                    do { 
                        System.out.println("Introduce el email: ");
                        email = sc.nextLine();
                        sc.nextLine();
                        if (clienteDAO.existeEmail(email)) {
                            System.out.println("El email ya está registrado. Intente con otro.");
                        }
                    } while (clienteDAO.existeEmail(email));
                    clienteDAO.actualizarEmailCliente(dni, email);
                    System.out.println("Email modificado correctamente");
                }
                case 6 -> {
                    do {
                        System.out.println("Introduce el dni nuevo: ");
                        dni = sc.nextLine();
                        sc.nextLine();
                        if (clienteDAO.existeDni(dni)) {
                            System.out.println("El DNI ya está registrado. Intente con otro.");
                        }
                    } while (clienteDAO.existeDni(dni));
                    clienteDAO.actualizarDniCliente(cliente.getDni(), dni);
                    System.out.println("Dni modificado correctamente");
                }
                case 7 -> System.out.println("Volviendo al menu anterior");
            }
        } while (opcion != 7);


    }

    public void listarClientes() {
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
        System.out.println("Lista de clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
}