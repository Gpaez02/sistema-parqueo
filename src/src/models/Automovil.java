package models;


public class Automovil extends Vehiculo {
    private String tipoCombustible;  // Variable para almacenar el tipo de combustible del automóvil


    // Constructor de la clase Automovil
    public Automovil(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, String tipoCombustible) {
        // Llamada al constructor de la clase base (Vehiculo) para inicializar los atributos comunes
        super(placa, marca, modelo, horaEntrada);  // Hereda los atributos 'placa', 'marca', 'modelo' y 'horaEntrada' de la clase Vehiculo
        this.tipoCombustible = tipoCombustible; // Inicializa el tipo de combustible del automóvil
    }


    // Getter para obtener el tipo de combustible
    public String getTipoCombustible() {
        return tipoCombustible;
    }


    // Setter para modificar el tipo de combustible
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
