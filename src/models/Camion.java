package models;

public class Camion extends Vehiculo {
    private double capacidadCarga;

    // Constructor
    public Camion(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, double capacidadCarga) {
        super(placa, marca, modelo, horaEntrada);
        this.capacidadCarga = capacidadCarga;
    }

    // Getter
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    // Setter
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
