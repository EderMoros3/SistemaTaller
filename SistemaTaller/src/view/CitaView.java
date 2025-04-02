package view;

import dao.CitaDAO;
import java.util.Scanner;
import model.Cita;
import model.Cliente;
public class CitaView {
    private Scanner sc = new Scanner(System.in);
    private CitaDAO citaDAO = new CitaDAO();
    private ClienteView clienteView = new ClienteView();
    
    public void gestionCitas() {
        int opcion;
        do {
            System.out.println("Gestion de citas");
            System.out.println("-------------------");
            System.out.println("1. Agregar cita");
            System.out.println("2. Modificar cita");
            System.out.println("3. Eliminar cita");
            System.out.println("4. Listar citas");
            System.out.println("5. Volver al menu principal");
            opcion = sc.nextInt();

            switch (opcion) {
                        case 1 -> this.agregarCita();
                        case 2 -> this.modificarCita();
                        case 3 -> this.eliminarCita();
                        case 4 -> this.listarCitas();
                        case 5 -> System.out.println("Volviendo al menu principal");
                    }
        } while (opcion != 5);
    }

    public void menuCitasCliente() {
        int opcion;
        do {
            System.out.println("Menu citas cliente");
            System.out.println("1. Agregar cita");
            System.out.println("2. Modificar cita");
            System.out.println("3. Eliminar cita");
            System.out.println("4. Listar citas personales");
            System.out.println("5. Volver al menu anterior");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> this.agregarCita();
                case 2 -> this.modificarCita();
                case 3 -> this.eliminarCita();
                case 4 -> this.listarCitasCliente();
                case 5 -> System.out.println("Volviendo al menu anterior");
            }
        } while (opcion != 5);
    }

    public void agregarCita() {
        System.out.println("Agregar Cita");        
        System.out.println("Insertar fecha de cita (DIA-MES-AÑO: ");
        String fecha = sc.nextLine();
        sc.next();
        System.out.println("Insertar hora de cita (XX-XX)(12.35)(FORMATO 24H): ");
        String hora = sc.nextLine();
        sc.next();
        System.out.println("Agregue una descripcion a la cita: ");
        String descripcion = sc.nextLine();
        sc.next();
        Cliente cliente = clienteView.getClienteDni();  

        Cita cita = new Cita(cliente, fecha, hora, descripcion);
        citaDAO.insertarCita(cita);
        
    }

    public void eliminarCita() {
        Cita cita = this.getCitaId();
        citaDAO.eliminarCita(cita);
        System.out.println("Cita eliminada correctamente");
    }

    public Cita getCitaId() {
        System.out.println("Introduzca el ID de la cita: ");
        int idCita = sc.nextInt();
        Cita cita = citaDAO.getCitaId(idCita);
        return cita;
    }

    public void listarCitas() {
        citaDAO.listarCitas();
    }

    public void listarCitasCliente() {
        System.out.println("Introduzca el dni del cliente: ");
        String dni = sc.nextLine();
        citaDAO.listarCitasCliente(dni);
    }

    public void modificarCita() {
        int opcion;
        Cita cita = this.getCitaId();

        do {
            System.out.println("Modificar cita");
            System.out.println("1. Modificar cliente");
            System.out.println("2. Modificar fecha");
            System.out.println("3. Modificar hora");
            System.out.println("4. Modificar descripcion");
            System.out.println("5. Volver al menu anterior");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduza el dni del cliente: ");
                    Cliente cliente = clienteView.getClienteDni();
                    citaDAO.modificarClienteCita(cliente, cita);
                    System.out.println("Cliente modificado correctamente");
                }
                case 2 -> {
                    System.out.println("Introduzca la nueva fecha: ");
                    String fecha = sc.nextLine();
                    sc.next();
                    citaDAO.modificarFechaCita(cita, fecha);
                    System.out.println("Fecha modificada correctamente");
                }
                case 3 -> {
                    System.out.println("Introduzca la nueva hora: ");
                    String hora = sc.nextLine();
                    sc.next();
                    citaDAO.modificarHoraCita(cita, hora);
                    System.out.println("Hora modificada correctamente");
                }
                case 4 -> {
                    System.out.println("Introduzca la nueva descripcion: ");
                    String descripcion = sc.nextLine();
                    sc.next();
                    citaDAO.modificarDescripcionCita(cita, descripcion);
                    System.out.println("Descripcion modificada correctamente");
                }
                case 5 -> System.out.println("Volviendo al menu anterior");
            }
        } while (opcion != 5);
    }
}
