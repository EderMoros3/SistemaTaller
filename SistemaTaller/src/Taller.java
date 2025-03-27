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