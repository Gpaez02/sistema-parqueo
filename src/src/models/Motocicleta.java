
package models;


public class Motocicleta extends Vehiculo {
    private int cilindraje;  // Variable para almacenar el cilindraje de la motocicleta


    // Constructor de la clase Motocicleta
    public Motocicleta(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, int cilindraje) {
        // Llamada al constructor de la clase base (Vehiculo) para inicializar los atributos comunes
        super(placa, marca, modelo, horaEntrada);  // Hereda los atributos 'placa', 'marca', 'modelo' y 'horaEntrada' de la clase Vehiculo
        this.cilindraje = cilindraje;  // Inicializa el cilindraje de la motocicleta
    }


    // Getter para obtener el cilindraje
    public int getCilindraje() {
        return cilindraje;
    }


    // Setter para modificar el cilindraje
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}








