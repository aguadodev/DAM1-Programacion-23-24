package ud7.javafxpracticas.mapaV03;

import javafx.scene.image.Image;

public class PersonajeFX {
    int filJugador;
    int colJugador;

    Image imagen;
    String color;

    // Color o dibujo para representar el personaje

    public PersonajeFX(int filJugador, int colJugador) {
        this.filJugador = filJugador;
        this.colJugador = colJugador;
        this.color = "Cyan"; // Color por defecto
        this.imagen = null; // Imagen por defecto
    }

    public int getFilJugador() {
        return filJugador;
    }

    public void setFilJugador(int filJugador) {
        this.filJugador = filJugador;
    }

    public int getColJugador() {
        return colJugador;
    }

    public void setColJugador(int colJugador) {
        this.colJugador = colJugador;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
