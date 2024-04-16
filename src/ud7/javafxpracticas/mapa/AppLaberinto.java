package ud7.javafxpracticas.mapa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLaberinto extends Application{

    int filJugador;
    int colJugador;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("AppLaberinto");

        String[] mapaStr = {
        "XXXXXXXXXXXXXX",
        "S            X",
        "X  XXXXXXX   X",
        "X            X",
        "X    XXXXXXX X",
        "X            X",
        "XXXXXXXXXXXX F"
        };

        MapaFX mapa = new MapaFX(mapaStr); 

        filJugador = mapa.getFilInicio();
        colJugador = mapa.getColInicio();

        mapa.dibujarJugador(filJugador, colJugador);

        Scene scene = new Scene(mapa.gridPane());

        primaryStage.setScene(scene);

        primaryStage.show();

    }
    
}
