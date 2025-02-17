package models;

public class Camion extends Vehiculo {
    private double capacidadCarga;  // Variable para almacenar la capacidad de carga del camión

    // Constructor de la clase Camion
    public Camion(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, double capacidadCarga) {
        // Llamada al constructor de la clase base (Vehiculo) para inicializar los atributos comunes
        super(placa, marca, modelo, horaEntrada);  // Hereda los atributos 'placa', 'marca', 'modelo' y 'horaEntrada' de la clase Vehiculo
        this.capacidadCarga = capacidadCarga; // Inicializa la capacidad de carga del camión
    }

    // Getter para obtener la capacidad de carga
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    // Setter para modificar la capacidad de carga
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
