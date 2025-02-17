package models;

import java.time.LocalDateTime;

public class Vehiculo {
    private String placa;  // Variable para almacenar la placa del vehículo
    private String marca;  // Variable para almacenar la marca del vehículo
    private String modelo; // Variable para almacenar el modelo del vehículo
    private LocalDateTime horaEntrada;  // Variable para almacenar la hora de entrada al parqueadero

    // Constructor de la clase Vehiculo
    public Vehiculo(String placa, String marca, String modelo, LocalDateTime horaEntrada) {
        this.placa = placa;  // Inicializa la placa del vehículo
        this.marca = marca;  // Inicializa la marca del vehículo
        this.modelo = modelo;  // Inicializa el modelo del vehículo
        this.horaEntrada = horaEntrada;  // Inicializa la hora de entrada del vehículo
    }

    // Getters para obtener los valores de los atributos
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    // Setters para modificar los valores de los atributos
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
}
