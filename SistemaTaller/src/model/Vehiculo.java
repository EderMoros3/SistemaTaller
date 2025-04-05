package model;
public class Vehiculo {
    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private int ano;
    private Cliente titular;

    // constrcutor
    public Vehiculo(String matricula, String marca, String modelo, int ano, Cliente titular) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.titular = titular;

    }

    // getters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getYear() { return ano; }
    public Cliente getTitular() { return titular; }

    // setters
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setYear(int ano) { this.ano = ano; }
    public void setTitular(Cliente titular) { this.titular = titular; }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", year=" + ano
                + ", titular=" + titular + "]";
    }
}
