package models;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    // Constructor
    public Motocicleta(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, int cilindraje) {
        super(placa, marca, modelo, horaEntrada);
        this.cilindraje = cilindraje;
    }

    // Getter
    public int getCilindraje() {
        return cilindraje;
    }

    // Setter
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
