import java.util.ArrayList;
import java.util.Scanner;

import model.Cita;
import model.Cliente;
import model.Empleado;
import model.Pieza;
import model.Vehiculo;

public class Taller {
    Scanner sc = new Scanner(System.in);

    // Atributos
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    ArrayList<Pieza> listaPiezas = new ArrayList<>();
    ArrayList<Cita> listaCitas = new ArrayList<>();

    // Constructor
    public Taller() {
        this.listaEmpleados = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaPiezas = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
    }

    // Getters
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
    public Cita getCitaID() {
        int idCita;
        if (!this.listaCitas.isEmpty()) {
            do {
                System.out.println("Introduce el ID del empleado: ");
                idCita = sc.nextInt();

                for (Cita cita : this.listaCitas) {
                    if (cita.getIdCita() == (idCita)) {
                        return cita;
                    }
                }
                System.out.println("No se encontro ninguna Cita con ese ID");
            } while (true);
        }
        return null;
    }
    
    // Metodos menus
    
    
    
    
    
    public void gestionPedidos() {
    }

   

    // MetodosClientes
    

    
    
    

    // MetodosEmpleados
    

    
    public void listarAsignaciones() {
        Empleado empleado = this.getEmpleadoID();

    } // falta terminar asignaciones

    

    // MetodosVehiculos
   
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

    
    // Metodos Inventario

    

    public Pieza getPiezaReferencia() {
        String referencia;
        if (!this.listaPiezas.isEmpty()) {
            do {
                System.out.println("Introduce la referencia de la pieza: ");
                referencia = sc.nextLine();
                sc.next();
                for (Pieza pieza : this.listaPiezas) {
                    if (pieza.getReferencia().equals(referencia)) {
                        return pieza;
                    }
                }
                System.out.println("No se encontro ninguna pieza con esa referencia");
            } while (true);
        }
        return null;
    }

    public void modificarPieza() {
        System.out.println("Modificar pieza");
        Pieza pieza = this.getPiezaReferencia();
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
                pieza.setReferencia(referencia);
                System.out.println("Referencia modificada correctamente");
            }

            case 2 -> {
                System.out.println("Introduce la marca: ");
                String marca = sc.nextLine();
                sc.next();
                pieza.setMarca(marca);
                System.out.println("Marca modificada correctamente");
            }

            case 3 -> {
                System.out.println("Introduce la descripcion: ");
                String descripcion = sc.nextLine();
                sc.next();
                pieza.setDescripcion(descripcion);
                System.out.println("Descripcion modificada correctamente");
            }

            case 4 -> {
                Double precioPieza;
                do {
                    System.out.println("Introduce el precio: ");
                    precioPieza = sc.nextDouble();
                } while (precioPieza < 0);
                pieza.setPrecio(precioPieza);
                System.out.println("Precio modificado correctamente");
            }

            case 5 -> {
                int cantidad;
                do {
                    System.out.println("Introduce la cantidad: ");
                    cantidad = sc.nextInt();
                } while (cantidad < 0);
                pieza.setCantidad(cantidad);
                System.out.println("Cantidad modificada correctamente");
            }

            case 6 -> System.out.println("Volviendo al menu anterior");
        }

    }

    
    //metodosCitas
    
    public void modificarCita() {
        Cita cita = this.getCitaID();
        System.out.println("Modificar Cita");
        System.out.println("---------------");
        System.out.println("Insertar ID de cita: ");
        int idCita = sc.nextInt();
        System.out.println("");
    }
}