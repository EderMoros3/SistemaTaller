package view;

import dao.ProveedorDAO;

import java.util.ArrayList;
import java.util.Scanner;
import model.Proveedor;

public class ProveedorView {
    Scanner sc = new Scanner(System.in);
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    
    public void gestionProveedores() {
        int opcion;
        do {
            System.out.println("Gestion de Proveedores");
            System.out.println("---------------------");
            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Modificar Proveedor");
            System.out.println("3. Eliminar Proveedor");
            System.out.println("4. Listar Proveedores");
            System.out.println("5. Volver al Menu Principal");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> this.agregarProveedor();
                case 2 -> this.modificarProveedor();
                case 3 -> this.eliminarProveedor();
                case 4 -> this.listarProveedores();
                case 5 -> System.out.println("Volver al Menu Principal");
            }
        } while (opcion != 5);

    }

    public void agregarProveedor() {
        System.out.println("Agregar Proveedor");
        System.out.println("-----------------------");
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        
        int telefono;
        do {
            System.out.println("Introduce el telefono del proveedor: ");
            telefono = sc.nextInt();
            
            if (proveedorDAO.existeTelefono(telefono)) {
                System.out.println("El telefono ya existe, por favor ingrese otro.");
            } 
        } while (proveedorDAO.existeTelefono(telefono));
        
        System.out.println("Ingrese la direccion del proveedor: ");
        String direccion = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Ingrese el correo del proveedor: ");
        String correo = sc.nextLine();
        sc.nextLine();

        Proveedor proveedor = new Proveedor(nombre, telefono, direccion, correo);    
        proveedorDAO.insertarProveedor(proveedor);
        System.out.println("Proveedor agregado correctamente");
    }

    public Proveedor getProveedorId() {
        System.out.println("Introduzca el ID del proveedor: ");
        int id = sc.nextInt();
        Proveedor proveedor = proveedorDAO.getProveedorID(id);
        return proveedor;
    }

    public void modificarProveedor() {
        Proveedor proveedor = this.getProveedorId();
        int idProveedor = proveedor.getIdProveedor();
        int opcion;

        do {
            System.out.println("Modificar Proveedor");
            System.out.println("---------------------");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar telefono");
            System.out.println("3. Modificar direccion");
            System.out.println("4. Modificar correo");
            System.out.println("5. Volver al Menu Principal");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduzca el nuevo nombre: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();
                    proveedorDAO.modificarNombreProveedor(idProveedor, nombre);
                    System.out.println("Nombre modificado correctamente");
                }
    
                case 2 -> {
                    System.out.println("Introduzca el nuevo telefono: ");
                    int telefono = sc.nextInt();
                    proveedorDAO.modificarTelefonoProveedor(idProveedor, telefono);
                    System.out.println("Telefono modificado correctamente");
                }
    
                case 3 -> {
                    System.out.println("Introduzca la nueva direccion: ");
                    String direccion = sc.nextLine();
                    sc.nextLine();
                    proveedorDAO.modificarDireccionProveedor(idProveedor, direccion);
                    System.out.println("Direccion modificada correctamente");
                }
    
                case 4 -> {
                    System.out.println("Introduzca el nuevo email: ");
                    String correo = sc.nextLine();
                    sc.nextLine();
                    proveedorDAO.modificarEmailProveedor(idProveedor, correo);
                    System.out.println("Email modificado correctamente");
                }
    
                case 5 -> System.out.println("Volver al Menu Principal");
            }
        } while (opcion != 5);
    }


    public void eliminarProveedor() {
        Proveedor proveedor = this.getProveedorId();
        proveedorDAO.eliminarProveedor(proveedor);
        System.out.println("Proveedor eliminado correctamente");
    }

    public void listarProveedores() {
        ArrayList<Proveedor> proveedores = proveedorDAO.listarProveedores();
        System.out.println("Lista de Proveedores: ");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor.toString());
        }
    }
}