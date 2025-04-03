package view;

import dao.CitaDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.Cita;
import model.Cliente;

public class CitaView {
    private Scanner sc = new Scanner(System.in);
    private CitaDAO citaDAO = new CitaDAO();
    private ClienteView clienteView;

    public CitaView() {}

    // Método para establecer la dependencia de ClienteView
    public void setClienteView(ClienteView clienteView) {
        this.clienteView = clienteView;
    }

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

        } while (opcion != 5);
        
        switch (opcion) {
            case 1 -> this.agregarCita();
            case 2 -> this.modificarCita();
            case 3 -> this.eliminarCita();
            case 4 -> this.listarCitas();
            case 5 -> System.out.println("Volviendo al menu principal");
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
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
            
        } while (opcion != 5);

        switch (opcion) {
            case 1 -> this.agregarCita();
            case 2 -> this.modificarCita();
            case 3 -> this.eliminarCita();
            case 4 -> this.listarCitasCliente();
            case 5 -> System.out.println("Volviendo al menu anterior");
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    public void agregarCita() {
        System.out.println("Agregar Cita");
        
        // Validación de fecha
        String fecha;
        boolean fechaValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHoy = LocalDate.now();
        
        do {
            System.out.println("Insertar fecha de cita (DIA-MES-AÑO, formato dd-MM-yyyy): ");
            fecha = sc.nextLine();
            
            try {
                LocalDate fechaCita = LocalDate.parse(fecha, formatter);
                
                if (fechaCita.isBefore(fechaHoy)) {
                    System.out.println("Error: La fecha no puede ser anterior a hoy (" 
                                      + fechaHoy.format(formatter) + ")");
                } else {
                    fechaValida = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Use dd-MM-yyyy (ej: 25-12-2023)");
            }
        } while (!fechaValida);
    
        // Validación de hora
        int horas;
        int minutos;
        boolean horaValida = false;
        boolean minutoValido = false;
        
        System.out.println("Insertar hora para la cita:");
        do { 
            System.out.println("Insertar hora: (formato 24H - SOLO INTRODUCIR LA HORA: )");
            horas = sc.nextInt();
            if (horas > 23 || horas < 0) {
                System.out.println("Error: Hora invalida, introduce una hora valida");
            } else {
                horaValida = true;
            }            
        } while (!horaValida);
    
        do { 
            System.out.println("Insertar minutos: (xx) (SOLO LOS MINUTOS)");
            minutos = sc.nextInt();
            if (minutos > 59 || minutos < 0) {
                System.out.println("Error: Minutos invalidos, introduce minutos validos");
            } else {
                minutoValido = true;
            }
        } while (!minutoValido);
        
        String hora = String.format("%02d:%02d", horas, minutos);
        sc.next(); // Limpiar buffer
        
        System.out.println("Agregue una descripcion a la cita: ");
        String descripcion = sc.nextLine();
        
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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHoy = LocalDate.now();
    
        do {
            System.out.println("Modificar cita");
            System.out.println("1. Modificar cliente");
            System.out.println("2. Modificar fecha");
            System.out.println("3. Modificar hora");
            System.out.println("4. Modificar descripción");
            System.out.println("5. Volver al menu anterior");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
    
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduzca el DNI del nuevo cliente: ");
                    Cliente cliente = clienteView.getClienteDni();
                    citaDAO.modificarClienteCita(cliente, cita);
                    System.out.println("Cliente modificado correctamente");
                }
                
                case 2 -> {
                    String nuevaFecha;
                    boolean fechaValida = false;
                    
                    do {
                        System.out.println("Introduzca la nueva fecha (dd-MM-yyyy): ");
                        nuevaFecha = sc.nextLine(); sc.next();
                        
                        try {
                            LocalDate fechaCita = LocalDate.parse(nuevaFecha, dateFormatter);
                            
                            if (fechaCita.isBefore(fechaHoy)) {
                                System.out.println("Error: La fecha no puede ser anterior a hoy (" 
                                                + fechaHoy.format(dateFormatter) + ")");
                            } else {
                                fechaValida = true;
                                citaDAO.modificarFechaCita(cita, nuevaFecha);
                                System.out.println("Fecha modificada correctamente");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha incorrecto. Use dd-MM-yyyy (ej: 25-12-2023)");
                        }
                    } while (!fechaValida);
                }
                
                case 3 -> {
                    int horas;
                    int minutos;
                    boolean horaValida = false;
                    boolean minutoValido = false;
                    String nuevaHora;
                    
                    System.out.println("Modificar hora de la cita:");
                    
                    // Validación de horas
                    do {
                        System.out.print("Ingrese la nueva hora (0-23): ");
                        horas = sc.nextInt();
                        if (horas < 0 || horas > 23) {
                            System.out.println("Hora inválida. Debe ser entre 0 y 23.");
                        } else {
                            horaValida = true;
                        }
                    } while (!horaValida);
                    
                    // Validación de minutos
                    do {
                        System.out.print("Ingrese los nuevos minutos (0-59): ");
                        minutos = sc.nextInt();
                        if (minutos < 0 || minutos > 59) {
                            System.out.println("Minutos inválidos. Debe ser entre 0 y 59.");
                        } else {
                            minutoValido = true;
                        }
                    } while (!minutoValido);
                    
                    sc.nextLine(); // Limpiar buffer
                    nuevaHora = String.format("%02d:%02d", horas, minutos);
                    citaDAO.modificarHoraCita(cita, nuevaHora);
                    System.out.println("Hora modificada correctamente a: " + nuevaHora);
                }
                
                case 4 -> {
                    System.out.println("Introduzca la nueva descripción: ");
                    String descripcion = sc.nextLine();
                    sc.next();
                    citaDAO.modificarDescripcionCita(cita, descripcion);
                    System.out.println("Descripción modificada correctamente");
                }
                
                case 5 -> System.out.println("Volviendo al menu anterior");
                
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
