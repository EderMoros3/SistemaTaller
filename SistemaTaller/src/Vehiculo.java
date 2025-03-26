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

    // Setters
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setYear(int year) { this.year = year; }
    public void setTitular(Cliente titular) { this.titular = titular; }

    // Getters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getYear() { return year; }
    public Cliente getTitular() { return titular; }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", year=" + year
                + ", titular=" + titular + "]";
    }
}
