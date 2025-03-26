import java.util.Scanner;
import java.util.ArrayList;

public class Taller {
    // Atributos
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Constructor
    public Taller() {
        this.listaClientes = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
    }

    // Metodos cliente
    public void gestionClientes() {
        int opcion;
        do {
            System.out.println("Gestion de clientes");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Listar clientes");
        System.out.println("5. Volver al menu principal");
        System.out.println("Ingrese una opcion: ");
        opcion = sc.nextInt();
        } while (opcion != 5);
        
        switch (opcion) {
            case 1 -> this.agregarCliente();
            case 2 -> this.modificarCliente();
            case 3 -> this.eliminarCliente();
            case 4 -> this.listarClientes();
            case 5 -> System.out.println("Volviendo al menu principal");
        }
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
        listaClientes.add(cliente);
        System.out.println("Cliente agregado correctamente");
    }

    public Cliente getClienteDni() {
        String dni;
        if (!this.listaClientes.isEmpty()) {
            do {
                System.out.println("Introduce el dni del cliente: ");
                dni = sc.nextLine();
                sc.next();
                for (Cliente cliente : this.listaClientes) {
                    if (cliente.getDni().equals(dni)) {
                        return cliente;
                    }
                }
                System.out.println("No se encontro ningun cliente con ese dni");
            } while (true);
        }
        return null;
    }   

    public void modificarCliente() {
        Cliente cliente = this.getClienteDni();
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
                cliente.setNombre(nombre);
                System.out.println("Nombre modificado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el apellido: ");
                String apellido = sc.nextLine();
                sc.next();
                cliente.setApellido(apellido);
                System.out.println("Apellido modificado correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el telefono: ");
                int telefono = sc.nextInt();
                cliente.setTelefono(telefono);
                System.out.println("Telefono modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce la direccion: ");
                String direccion = sc.nextLine();
                sc.next();
                cliente.setDireccion(direccion);
                System.out.println("Direccion modificada correctamente");
            }
            case 5 -> {
                System.out.println("Introduce el email: ");
                String email = sc.nextLine();
                sc.next();
                cliente.setEmail(email);
                System.out.println("Email modificado correctamente");
            }
            case 6 -> {
                System.out.println("Introduce el dni: ");
                String dni = sc.nextLine();
                sc.next();
                cliente.setDni(dni);
                System.out.println("Dni modificado correctamente");
            }
            case 7 -> System.out.println("Volviendo al menu anterior");
        }
        
    }

    public void eliminarCliente() {
        Cliente cliente = this.getClienteDni();
        this.listaClientes.remove(cliente);
        System.out.println("Cliente eliminado correctamente");
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    // Metodos vehiculo
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
        } while (opcion != 5);

        switch (opcion) {
            case 1 -> this.agregarVehiculo();
            case 2 -> this.modificarVehiculo();
            case 3 -> this.eliminarVehiculo();
            case 4 -> this.listarVehiculos();
            case 5 -> System.out.println("Volviendo al menu principal");
        }
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
        Cliente titular = this.getClienteDni();
        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, year, titular);
        listaVehiculos.add(vehiculo);
        System.out.println("Vehiculo agregado correctamente");
    }

    public Vehiculo getVehiculoMatricula() {
        String matricula;
        if (!this.listaVehiculos.isEmpty()) {
            do {
                System.out.println("Introduce la matricula del vehiculo: ");
                matricula = sc.nextLine();
                sc.next();
                for (Vehiculo vehiculo : this.listaVehiculos) {
                    if (vehiculo.getMatricula().equals(matricula)) {
                        return vehiculo;
                    }
                }
                System.out.println("No se encontro ningun vehiculo con esa matricula");
            } while (true);
        }
        return null;
    }

    public void modificarVehiculo() {
        Vehiculo vehiculo = this.getVehiculoMatricula();
        System.out.println("Modificar vehiculo");
        System.out.println("1. Modificar matricula");
        System.out.println("2. Modificar marca");
        System.out.println("3. Modificar modelo");
        System.out.println("4. Modificar año");
        System.out.println("5. Modificar titular");
        System.out.println("6. Volver al menu anterior");
        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce la matricula: ");
                String matricula = sc.nextLine();
                sc.next();
                vehiculo.setMatricula(matricula);
                System.out.println("Matricula modificada correctamente");
            }
            case 2 -> {
                System.out.println("Introduce la marca: ");
                String marca = sc.nextLine();
                sc.next();
                vehiculo.setMarca(marca);
                System.out.println("Marca modificada correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el modelo: ");
                String modelo = sc.nextLine();
                sc.next();
                vehiculo.setModelo(modelo);
                System.out.println("Modelo modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce el año: ");
                int year = sc.nextInt();
                vehiculo.setYear(year);
                System.out.println("Año modificado correctamente");
            }
            case 5 -> {
                Cliente titular = this.getClienteDni();
                vehiculo.setTitular(titular);
                System.out.println("Titular modificado correctamente");
            }
            case 6 -> System.out.println("Volviendo al menu anterior");
        }
    }

    public void eliminarVehiculo() {
        Vehiculo vehiculo = this.getVehiculoMatricula();
        this.listaVehiculos.remove(vehiculo);
        System.out.println("Vehiculo eliminado correctamente");
    }

    public void listarVehiculos() {
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo);
        }
    }

}
