package ud7.javafxpracticas.mapaV03;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

public class MapaFX extends Mapa {
    final int ANCHO_CASILLA = 45;
    final int ALTO_CASILLA = 45;
    /**
     * Las casillas tienen distintos colores según su tipo. Los colores son:
     * - negro: muro
     * - verde: casilla de salida
     * - rojo: casilla de llegada
     * - blanco: casilla libre
     **/
    final String COLOR_MURO = "Black";
    final String COLOR_INICIO = "Green";
    final String COLOR_FIN = "Red";
    final String COLOR_LIBRE = "White";

    // Almacena la representación gráfica del mapa
    GridPane gridPane;

    /*
     * CONSTRUCTORES
     */

    /**
     * Constructor que acepta un array de Strings como valor inicial del mapa.
     * 
     * @param mapaStr
     */
    public MapaFX(String[] mapaStr) {
        super(mapaStr);
        this.gridPane = gridPane();
    }

    /**
     * Devuelve un GridPane con la representación de las casillas del mapa.
     * Cada casilla es un Label con un color de fondo distinto según el tipo de
     * casilla.
     * 
     * @return GridPane con las casillas del mapa
     */
    public GridPane gridPane() {
        this.gridPane = new GridPane();

        for (int i = 0; i < numFil; i++)
            for (int j = 0; j < numCol; j++) {
                Label label = new Label();
                label.setMinSize(ANCHO_CASILLA, ALTO_CASILLA);
                gridPane.add(label, j, i);
                pintarCasilla(i, j);
            }

        return gridPane;
    }

    /**
     * Pinta una casilla del gridPane con el color indicado.
     * 
     * @param fil   Fila
     * @param col   Columna
     * @param color Color de la casilla (ej. "green" o "#ff0000")
     */
    public void pintarCasilla(int fil, int col, String color) {
        Node casilla = gridPane.getChildren().get(fil * numCol + col);
        casilla.setStyle("-fx-background-color: " + color + ";");
    }

    /**
     * Pinta una casilla del gridPane con el color que corresponda según el tipo de
     * casilla.
     * 
     * @param fil Fila
     * @param col Columna
     */
    public void pintarCasilla(int fil, int col) {
        if (esMuro(fil, col))
            pintarCasilla(fil, col, COLOR_MURO);
        else if (esInicio(fil, col))
            pintarCasilla(fil, col, COLOR_INICIO);
        else if (esFin(fil, col))
            pintarCasilla(fil, col, COLOR_FIN);
        else {
            pintarCasilla(fil, col, COLOR_LIBRE);
        }
    }

    /**
     * Dibuja una imagen en la posición indicada.
     * 
     * @param imagen Imagen a dibujar
     * @param fil    Fila
     * @param col    Columna
     */
    public void dibujarImagen(Image imagen, int fil, int col) {
        ImageView img = new ImageView(imagen);
        img.setFitHeight(ALTO_CASILLA);
        img.setFitWidth(ANCHO_CASILLA);
        ((Label) (gridPane.getChildren().get(fil * numCol + col))).setGraphic(img);
    }

    /**
     * Mueve el personaje en la dirección indicada por el KeyCode.
     * 
     * @param personaje PersonajeFX a mover
     * @param code      KeyCode con la dirección del movimiento
     */
    public void moverPersonaje(PersonajeFX personaje, KeyCode code) {
        switch (code) {
            case UP -> {
                if (!esMuro(personaje.filJugador - 1, personaje.colJugador)) {
                    borrarPersonaje(personaje);
                    personaje.filJugador--;
                    dibujarPersonaje(personaje);
                }
            }
            case DOWN -> {
                if (!esMuro(personaje.filJugador + 1, personaje.colJugador)) {
                    borrarPersonaje(personaje);
                    personaje.filJugador++;
                    dibujarPersonaje(personaje);
                }
            }
            case LEFT -> {
                if (!esMuro(personaje.filJugador, personaje.colJugador - 1)) {
                    borrarPersonaje(personaje);
                    personaje.colJugador--;
                    dibujarPersonaje(personaje);
                }
            }
            case RIGHT -> {
                if (!esMuro(personaje.filJugador, personaje.colJugador + 1)) {
                    borrarPersonaje(personaje);
                    personaje.colJugador++;
                    dibujarPersonaje(personaje);
                }
            }
            default -> System.out.println("KeyCode sin acción asignada: " + code);
        }
    }

    /**
     * Dibuja el personaje en la posición actual del jugador.
     * Si el personaje tiene imagen, la dibuja. Si no, pinta el color del jugador.
     * TODO: Y si no tiene color?
     * 
     * @param p PersonajeFX a dibujar
     */
    public void dibujarPersonaje(PersonajeFX p) {
        if (p == null)
            return;

        if (p.getImagen() != null) {
            // Pinta la imagen del jugador
            ImageView img = new ImageView(p.getImagen());
            img.setFitHeight(ALTO_CASILLA);
            img.setFitWidth(ANCHO_CASILLA);
            ((Label) (gridPane.getChildren().get(p.filJugador * numCol + p.colJugador))).setGraphic(img);
        } else {
            // Pinta el color del jugador
            pintarCasilla(p.filJugador, p.colJugador, p.color);
        }
    }

    /**
     * Borra el personaje de la posición actual del jugador.
     * 
     * @param p
     */
    public void borrarPersonaje(PersonajeFX p) {
        pintarCasilla(p.filJugador, p.colJugador);
        // Borra la imagen del jugador si la tiene
        ((Label) (gridPane.getChildren().get(p.filJugador * numCol + p.colJugador))).setGraphic(null);
    }

}
