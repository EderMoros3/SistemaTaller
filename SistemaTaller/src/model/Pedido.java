package model;

import java.util.ArrayList;

public class Pedido {
    //Atributos
    private int idPedido;
    private String fechaPedido;
    private String fechaEntrega;
    private Boolean estado;
    private Double precio;
    private Proveedor proveedor;
    ArrayList<Pieza> pieza = new ArrayList<>();

    //Constructor
    public Pedido(String fechaPedido, String fechaEntrega, Boolean estado, Double precio, Proveedor proveedor) {
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    //Getters
    public int getIdPedido() {return idPedido;}
    public String getFechaPedido() {return fechaPedido;}
    public String getFechaEntrega() {return fechaEntrega;}
    public Boolean getEstado() {return estado;}
    public Double getPrecio() {return precio;}
    public Proveedor getProveedor() {return proveedor;}
    public ArrayList<Pieza> getPieza() {return pieza;}

    //Setters
    public void setIdPedido(int idPedido) {this.idPedido = idPedido;}
    public void setFechaPedido(String fechaPedido) {this.fechaPedido = fechaPedido;}
    public void setFechaEntrega(String fechaEntrega) {this.fechaEntrega = fechaEntrega;}
    public void setEstado(Boolean estado) {this.estado = estado;}
    public void setPrecio(Double precio) {this.precio = precio;}
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}
    public void setPieza(ArrayList<Pieza> pieza) {this.pieza = pieza;}

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
                + ", estado=" + estado + ", precio=" + precio + ", proveedor=" + proveedor + ", pieza=" + pieza + "]";
    }

    

}
