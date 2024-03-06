package ud5.examenud05;
// Clase para objetos electrónicos

import java.time.LocalDateTime;

public class ObjetoElectronico extends Objeto {
    private String marca;
    private String modelo;
    
    public ObjetoElectronico(String nombre, String descripcion, String ubicacion, User usuarioPublicacion,
            LocalDateTime fechaHoraPublicacion, User usuarioRecogida, LocalDateTime fechaHoraRecogida, boolean recogido,
            String marca, String modelo) {
        super(nombre, descripcion, ubicacion, usuarioPublicacion, fechaHoraPublicacion, usuarioRecogida,
                fechaHoraRecogida, recogido);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return nombre + " - ObjetoElectronico [marca=" + marca + ", modelo=" + modelo + "]";
    }


    
    

}
