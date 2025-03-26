public class Vehiculo {
    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private int year;
    private Cliente titular;

    // Constructor
    public Vehiculo(String matricula, String marca, String modelo, int year, Cliente titular) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.titular = titular;
    }
}
