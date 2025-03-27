package view;

import java.util.Scanner;
import model.Cita;
import dao.CitaDAO;
import dao.ClienteDAO;
public class CitaView {
    private Scanner sc = new Scanner(System.in);
    private CitaDAO citaDAO = new CitaDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    
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
                        case 1 -> agregarCita();
                        case 2 -> modificarCita();
                        case 3 -> eliminarCita();
                        case 4 -> listarCitas();
                        case 5 -> System.out.println("Volviendo al menu principal");
                    }
        } while (opcion != 5);
    }

    public void agregarCita() {
        System.out.println("Agregar Cita");
        System.out.println("---------------");
        System.out.println("Insertar ID de cita: ");
        int idCita = sc.nextInt();
        System.out.println("Insertar fecha de cita (DIA-MES-AÑO: ");
        String fecha = sc.nextLine();
        sc.next();
        System.out.println("Insertar hora de cita (XX-XX)(12.35)(FORMATO 24H): ");
        String hora = sc.nextLine();
        sc.next();
        System.out.println("Agregue una descripcion a la cita: ");
        String descripcion = sc.nextLine();
        sc.next();
        Cliente cliente = clienteDAO.getClienteDni();  

        Cita cita = new Cita(idCita, cliente, fecha, hora, descripcion);
        citaDAO.listaCitas.add(cita);
    }
}
