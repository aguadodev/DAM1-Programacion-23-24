package ud7.javafxpracticas.mapa;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MapaFX extends Mapa {
    GridPane gridPane;

    public MapaFX(String[] mapaStr) {
        super(mapaStr);
        this.gridPane = gridPane();
    }

    public GridPane gridPane() {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < numFil; i++)
            for(int j = 0; j < numCol; j++) {
                Label label = new Label();
                label.setMinSize(40,40);

                if (esMuro(i, j))
                    label.setStyle("-fx-background-color: #000000;");
                gridPane.add(label, j, i);
            }

        return gridPane;
    }

    public void dibujarJugador(int filJugador, int colJugador) {
        // TODO Dibujar al jugador en la celda indica
    }
    
}
