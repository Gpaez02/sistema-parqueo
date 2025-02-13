import models.Vehiculo;
import models.Automovil;
import models.Motocicleta;
import models.Camion;
import models.Parqueadero;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();
        int opcion;

        do {
            System.out.println("\n--- Menú Parqueadero ---");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Verificar que el usuario ingrese un número
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Seleccione una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    ingresarVehiculo(scanner, parqueadero);
                    break;
                case 2:
                    registrarSalida(scanner, parqueadero);
                    break;
                case 3:
                    consultarEstado(parqueadero);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    // Método para ingresar un vehículo
    private static void ingresarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("Ingrese el tipo de vehículo (1: Automóvil, 2: Motocicleta, 3: Camión): ");

        // Validar que ingrese un número correcto
        int tipo;
        while (true) {
            if (scanner.hasNextInt()) {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                if (tipo >= 1 && tipo <= 3) {
                    break;
                }
            } else {
                scanner.next(); // Limpiar entrada incorrecta
            }
            System.out.println("Error: Ingrese un número válido (1, 2 o 3).");
        }

        System.out.print("Ingrese placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine();

        Vehiculo vehiculo = null;

        if (tipo == 1) {
            System.out.print("Ingrese tipo de combustible: ");
            String tipoCombustible = scanner.nextLine();
            vehiculo = new Automovil(placa, marca, modelo, LocalDateTime.now(), tipoCombustible);
        } else if (tipo == 2) {
            System.out.print("Ingrese cilindraje (número entero): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Ingrese cilindraje (número entero): ");
            }
            int cilindraje = scanner.nextInt();
            vehiculo = new Motocicleta(placa, marca, modelo, LocalDateTime.now(), cilindraje);
        } else if (tipo == 3) {
            System.out.print("Ingrese capacidad de carga (toneladas): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Ingrese capacidad de carga (toneladas): ");
            }
            double capacidadCarga = scanner.nextDouble();
            vehiculo = new Camion(placa, marca, modelo, LocalDateTime.now(), capacidadCarga);
        }

        parqueadero.registrarEntrada(vehiculo);
        System.out.println("Vehículo registrado con éxito.");
    }

    // Método para registrar la salida de un vehículo
    private static void registrarSalida(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del vehículo a retirar: ");
        String placaSalida = scanner.nextLine();
        double costo = parqueadero.registrarSalida(placaSalida);
        if (costo > 0) {
            System.out.println("El costo total es: $" + costo);
        } else {
            System.out.println("El vehículo no está en el parqueadero.");
        }
    }

    // Método para consultar el estado del parqueadero
    private static void consultarEstado(Parqueadero parqueadero) {
        System.out.println("\nVehículos en el parqueadero:");
        for (Vehiculo v : parqueadero.consultarEstado()) {
            System.out.println("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
        }
    }
}
