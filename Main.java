import java.util.Scanner;
import models.Vehiculo;
import models.Automovil;
import models.Motocicleta;
import models.Camion;
import models.Parqueadero;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Se crea un objeto de tipo Scanner para la entrada de datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Se crea el objeto parqueadero que gestiona los vehículos
        Parqueadero parqueadero = new Parqueadero();

        int opcion;

        do {
            // Imprimir el encabezado con el menú principal para interactuar con el sistema
            System.out.println("\n=====================================");
            System.out.println("    *** MENÚ PARQUEADERO ***        ");
            System.out.println("=====================================");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Ver tarifas del parqueadero");
            System.out.println("5. Generar reporte de vehículos");
            System.out.println("6. Salir");
            System.out.println("=====================================");
            System.out.print("Seleccione una opción: ");

            // Verificar que el usuario ingrese un número válido para la opción
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Seleccione una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea restante

            System.out.println(); // Agregar un salto de línea para la salida más legible

            // Evaluar la opción seleccionada
            switch (opcion) {
                case 1:  // Opción para ingresar un vehículo
                    parqueadero.ingresarVehiculo(scanner); // Llamada al método para ingresar vehículo
                    break;
                case 2:  // Opción para registrar la salida de un vehículo
                    System.out.print("Ingrese la placa del vehículo a retirar: ");
                    String placa = scanner.nextLine();
                    parqueadero.registrarSalida(placa); // Llamada al método para registrar salida
                    break;
                case 3:  // Opción para consultar los vehículos en el parqueadero
                    parqueadero.consultarEstado(); // Llamada al método que consulta el estado
                    break;
                case 4:  // Opción para ver las tarifas del parqueadero
                    parqueadero.mostrarTarifas(); // Llamada al método que muestra las tarifas
                    break;
                case 5:  // Opción para generar un reporte de vehículos
                    parqueadero.generarReporte();  // Llamada al método que genera el reporte
                    break;
                case 6:  // Opción para salir del sistema
                    System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                    break;
                default:  // Si la opción no es válida, muestra un mensaje de error
                    System.out.println("Opción no válida, intente de nuevo.");
            }

        } while (opcion != 6);  // El ciclo sigue hasta que el usuario seleccione la opción 6 (salir)

        scanner.close(); // Cerramos el objeto scanner para liberar recursos
    }
}
