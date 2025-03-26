import java.util.ArrayList;
import java.util.Scanner;

public class Taller {
    Scanner sc = new Scanner(System.in);

    //Listas
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    //constructor
    public Taller() {
        this.listaEmpleados = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    //getters
    public Empleado getEmpleadoID() {
        int idEmpleado;
        if (!this.listaEmpleados.isEmpty()) {
            do {
                System.out.println("Introduce el ID del empleado: ");
                idEmpleado = sc.nextInt();

                for (Empleado empleado : this.listaEmpleados) {
                    if (empleado.getIdEmpleado() == (idEmpleado)) {
                        return empleado;
                    }
                }
                System.out.println("No se encontro ningun empleado con ese ID");
            } while (true);
        }
        return null;
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


    //metodos menus
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

    public void gestionEmpleados() {
        int opcion;
        do {
            System.out.println("Gestion empleados");
            System.out.println("---------------------");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Listar asignaciones de un empleado por ID");
            System.out.println("5. Volver al Menu Principal");
            opcion = sc.nextInt();

        } while(opcion != 5);

        switch (opcion) {
            case 1 -> agregarEmpleado();
            case 2 -> modificarEmpleado();
            case 3 -> eliminarEmpleado();
            case 4 -> listarAsignaciones();
            case 5 -> System.out.println("Volver al Menu Principal");
        }


    }

    public void gestionServicios() {}

    public void gestionInvetario() {}

    public void gestionPedidos() {}

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

    public void gestionCitas() {}


    //metodosClientes
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

    //metodosEmpleados
    public void agregarEmpleado() {
        System.out.println("Agregar empleado");
        System.out.println("-----------------------");
        System.out.println("Ingrese el nombre del empleado");
        String nombre = sc.nextLine();
        sc.next();

        System.out.println("Ingrese el apellido del empleado");
        String apellido = sc.nextLine();
        sc.next();

        System.out.println("Ingrese el ID del empleado");
        int idEmpleado = sc.nextInt();

        System.out.println("Ingrese el telefono del empleado");
        int telefono = sc.nextInt();

        Empleado empleado = new Empleado(nombre, apellido, idEmpleado, telefono);
        listaEmpleados.add(empleado);
        System.out.println("Empleado agregado correctamente");
    }
    public void modificarEmpleado() {
        Empleado empleado = this.getEmpleadoID();
        int opcion;

        do {
            System.out.println("Modificar Empleado");
            System.out.println("-----------------------");
            System.out.println("1. Modificar nombre del empleado");
            System.out.println("2. Modificar apellido del empleado");
            System.out.println("3. Modificar ID del Empleado");
            System.out.println("4. Modificar telefono del Empleado");
            System.out.println("5. Volver a Gestion Empleados");
            opcion = sc.nextInt();

        } while (opcion != 5);

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre: ");
                String nombre = sc.nextLine();
                sc.next();
                empleado.setNombre(nombre);
                System.out.println("Nombre modificado correctamente");
            }
            case 2 -> {
                System.out.println("Introduce el apellido: ");
                String apellido = sc.nextLine();
                sc.next();
                empleado.setApellido(apellido);
                System.out.println("Apellido modificado correctamente");
            }
            case 3 -> {
                System.out.println("Introduce el ID: ");
                int ID = sc.nextInt();
                empleado.setTelefono(ID);
                System.out.println("ID modificado correctamente");
            }
            case 4 -> {
                System.out.println("Introduce el telefono: ");
                int telefono = sc.nextInt();
                empleado.setTelefono(telefono);
                System.out.println("Telefono modificado correctamente");
            }
            case 5 -> System.out.println("Volviendo a gestion de empleados");

        }
    }
    public void listarAsignaciones() {
        Empleado empleado = this.getEmpleadoID();


    } //falta terminar asignaciones
    public void eliminarEmpleado() {
        Empleado empleado = this.getEmpleadoID();
        this.listaEmpleados.remove(empleado);
        System.out.println("Empleado eliminado correctamente");
    }

    //metodosVehiculos
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
