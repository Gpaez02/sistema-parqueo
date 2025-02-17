package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Parqueadero {
    private List<Vehiculo> vehiculos;

    // Tarifas por hora para cada tipo de vehículo
    private static final double TARIFA_AUTOMOVIL = 5000;
    private static final double TARIFA_MOTOCICLETA = 3000;
    private static final double TARIFA_CAMION = 8000;

    // Constructor de la clase Parqueadero
    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    // Método para ingresar un vehículo al parqueadero
    public void ingresarVehiculo(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("  *** INGRESAR VEHÍCULO ***");
        System.out.println("=====================================");

      
        System.out.println("Ingrese tipo de vehículo (1: Automóvil, 2: Motocicleta, 3: Camión): ");
        System.out.println("=====================================");


        

        int tipo = 0;  // Inicializamos la variable para el tipo de vehículo

        // Bucle para asegurarse de que el usuario ingrese un valor válido
        while (tipo < 1 || tipo > 3) {
            System.out.print("Seleccione una opción (1, 2 o 3): ");
            
            if (scanner.hasNextInt()) {  // Verifica si la entrada es un número entero
                tipo = scanner.nextInt();  // Lee el número entero ingresado
                scanner.nextLine();  // Limpiar el salto de línea

                if (tipo < 1 || tipo > 3) {
                    System.out.println("Opción no válida. Debe ser 1, 2 o 3.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido (1, 2 o 3).");
                scanner.next();  // Limpiar la entrada incorrecta
            }
        }


        System.out.println("=====================================");
        System.out.print("Ingrese placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine();

        Vehiculo vehiculo = null;
        
        // Creación del vehículo según el tipo ingresado
        if (tipo == 1) {
            System.out.print("Ingrese tipo de combustible (e.g., gasolina, diésel, eléctrico): ");
            String combustible = scanner.nextLine();
            vehiculo = new Automovil(placa, marca, modelo, LocalDateTime.now(), combustible);
        } else if (tipo == 2) {
            System.out.print("Ingrese cilindraje (número entero, Ej: 150): ");
            int cilindraje = scanner.nextInt();
            scanner.nextLine();
            while (cilindraje <= 0) {
                System.out.println("Cilindraje no válido. Ingrese un número positivo.");
                cilindraje = scanner.nextInt();
                scanner.nextLine();
            }
            vehiculo = new Motocicleta(placa, marca, modelo, LocalDateTime.now(), cilindraje);
        } else if (tipo == 3) {
            System.out.print("Ingrese capacidad de carga (toneladas): ");
            double carga = scanner.nextDouble();
            scanner.nextLine();
            while (carga <= 0) {
                System.out.println("Capacidad de carga no válida. Ingrese un número positivo.");
                carga = scanner.nextDouble();
                scanner.nextLine();
            }
            vehiculo = new Camion(placa, marca, modelo, LocalDateTime.now(), carga);
        }

        // Registrar el vehículo en el parqueadero
        if (vehiculo != null) {
            vehiculos.add(vehiculo);
            System.out.println("");
            System.out.println("Vehículo registrado con éxito.");
        }
    }

    // Método para registrar la salida de un vehículo
    public double registrarSalida(String placa) {
        System.out.println("=====================================");
        System.out.println("   *** REGISTRAR SALIDA ***");
        System.out.println("=====================================");

        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPlaca().equals(placa)) {  // Comparar la placa ingresada con la del vehículo
                double costo = calcularCosto(vehiculo); // Calcular el costo antes de eliminar el vehículo
                iterator.remove(); // Eliminar el vehículo de la lista
                System.out.println("Vehículo con placa " + placa + " ha salido. Total a pagar: $" + costo);
                return costo;
            }
        }
        System.out.println("Vehículo con placa " + placa + " no encontrado.");
        return 0; // Retornar 0 si no se encontró el vehículo
    }

    // Método para consultar los vehículos dentro del parqueadero
    public void consultarEstado() {
        System.out.println("=====================================");
        System.out.println("   *** CONSULTAR ESTADO ***");
        System.out.println("=====================================");

        System.out.println("\nVehículos en el parqueadero:");
        for (Vehiculo v : vehiculos) {
            System.out.println("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
        }
    }

    // Método privado para calcular el costo de parqueo según el tipo de vehículo y la duración
    private double calcularCosto(Vehiculo vehiculo) {
        LocalDateTime horaSalida = LocalDateTime.now();  // Hora actual de salida
        Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida); // Duración de la estancia
        long horas = duracion.toHours(); // Convertir duración a horas
        if (duracion.toMinutes() % 60 > 0) {
            horas += 1; // Redondear a la hora completa si hay minutos adicionales
        }

        // Calcular el costo según el tipo de vehículo
        if (vehiculo instanceof Automovil) {
            return horas * TARIFA_AUTOMOVIL;
        } else if (vehiculo instanceof Motocicleta) {
            return horas * TARIFA_MOTOCICLETA;
        } else if (vehiculo instanceof Camion) {
            return horas * TARIFA_CAMION;
        } else {
            System.out.println("Tipo de vehículo no reconocido, costo de parqueo: $0.");
            return 0; // Retornar 0 si el tipo de vehículo no es reconocido
        }
    }

    // Método para mostrar las tarifas del parqueadero
    public void mostrarTarifas() {
        System.out.println("=====================================");
        System.out.println("   *** TARIFAS DEL PARQUEADERO ***");
        System.out.println("=====================================");
        System.out.println("Automóvil: $" + TARIFA_AUTOMOVIL + " por hora");
        System.out.println("Motocicleta: $" + TARIFA_MOTOCICLETA + " por hora");
        System.out.println("Camión: $" + TARIFA_CAMION + " por hora");
        System.out.println("=====================================");
    }

    // Método para generar el reporte de vehículos registrados en el parqueadero
    public void generarReporte() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados en el parqueadero.");
        } else {
            System.out.println("\n*** REPORTE DE VEHÍCULOS ***");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("Placa: " + vehiculo.getPlaca());
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());

                // Aquí convertimos la hora de entrada a la zona horaria de Bogotá, Colombia
                LocalDateTime horaEntrada = vehiculo.getHoraEntrada();
                if (!horaEntrada.atZone(ZoneId.of("America/Bogota")).getZone().equals(ZoneId.of("America/Bogota"))) {
                    // Si la hora no está en Bogotá, la convertimos
                    horaEntrada = horaEntrada.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/Bogota")).toLocalDateTime();
                }

                // Definimos el formato de la fecha y hora
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                // Imprimimos la hora de entrada en un formato más legible
                System.out.println("Hora de entrada: " + horaEntrada.format(formatter));
                System.out.println("---------------------------------");
            }
        }
    }
}
