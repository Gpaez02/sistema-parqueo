package models;

public class Automovil extends Vehiculo {
    private String tipoCombustible;

    // Constructor
    public Automovil(String placa, String marca, String modelo, java.time.LocalDateTime horaEntrada, String tipoCombustible) {
        super(placa, marca, modelo, horaEntrada);
        this.tipoCombustible = tipoCombustible;
    }

    // Getter
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    // Setter
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
