package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos;

    // Tarifas por hora
    private static final double TARIFA_AUTOMOVIL = 5000;
    private static final double TARIFA_MOTOCICLETA = 3000;
    private static final double TARIFA_CAMION = 8000;
   
    // Constructor
    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    // Método para registrar la entrada de un vehículo
    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha ingresado al parqueadero.");
    }

    // Método para registrar la salida de un vehículo y calcular el costo
    public double registrarSalida(String placa) {
    Iterator<Vehiculo> iterator = vehiculos.iterator();
    while (iterator.hasNext()) {
        Vehiculo vehiculo = iterator.next();
        if (vehiculo.getPlaca().equals(placa)) {
            double costo = calcularCosto(vehiculo); // Calcula antes de eliminar
            iterator.remove(); // Ahora sí, eliminas el vehículo
            System.out.println("Vehículo con placa " + placa + " ha salido. Total a pagar: $" + costo);
            return costo;
        }
    }
    System.out.println("Vehículo con placa " + placa + " no encontrado.");
    return 0;
}


    // Método para consultar los vehículos dentro del parqueadero
    public List<Vehiculo> consultarEstado() {
        return new ArrayList<>(vehiculos);
    }

    // Método privado para calcular el costo de parqueo
    private double calcularCosto(Vehiculo vehiculo) {
        LocalDateTime horaSalida = LocalDateTime.now();
        Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
        long horas = duracion.toHours();
        if (duracion.toMinutes() % 60 > 0) {
            horas += 1; // Redondeo a la hora completa
        }

        if (vehiculo instanceof Automovil) {
            return horas * TARIFA_AUTOMOVIL;
        } else if (vehiculo instanceof Motocicleta) {
            return horas * TARIFA_MOTOCICLETA;
        } else if (vehiculo instanceof Camion) {
            return horas * TARIFA_CAMION;
        } else {
            System.out.println("Tipo de vehículo no reconocido, costo de parqueo: $0.");
            return 0;
        }
    }
}
