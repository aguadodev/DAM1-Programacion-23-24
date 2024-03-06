package ud6.examenud05col;
// Clase para objetos de ropa

import java.time.LocalDateTime;

public class Ropa extends Objeto {
    private String talla;

    public Ropa(String nombre, String descripcion, String ubicacion, User usuarioPublicacion,
            LocalDateTime fechaHoraPublicacion, User usuarioRecogida, LocalDateTime fechaHoraRecogida, boolean recogido,
            String talla) {
                
        super(nombre, descripcion, ubicacion, usuarioPublicacion, fechaHoraPublicacion, usuarioRecogida,
                fechaHoraRecogida, recogido);
        this.talla = talla;
    }

    @Override
    public String toString() {
        return nombre + " - Ropa [talla=" + talla + "]";
    }

    
    
}