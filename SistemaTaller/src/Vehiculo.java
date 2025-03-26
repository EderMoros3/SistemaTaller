public class Vehiculo {
    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private int year;
    private int idCoche;
    private Cliente titular;


    //constrcutor
    public Vehiculo(String matricula, String marca, String modelo, int year, int idCoche, Cliente titular) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.idCoche = idCoche;
        this.titular = titular;

    }

    //getter
    public String getMatricula() {return matricula;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getYear() {return year;}
    public int getIdCoche() {return idCoche;}
    public Cliente getTitular() {return titular;}
}
