package ud7.javafxpracticas.mapaV01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppLaberintoV01 extends Application {
    MapaFX mapa;
    PersonajeFX personaje;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("AppLaberinto");

        String[] mapaStr1 = {
                "XXXXXXXXXXXXXX",
                "S          X X",
                "XX XXXXXXX X X",
                "X          X X",
                "X  X XXXXXXX X",
                "X  X         X",
                "XXXXXXXXXXXX F"
        };

        String[] mapaStr2 = {
            "XXXXXXXXXXXXXXXXXXXXXXX",
            "S X       X X   X     X",
            "X X XXX X X   X X X X X",
            "X X   X X X X X X X X X",
            "X XXX X X X X X X X X X",
            "X X   X X X X X X X X X",
            "X X XXX X X X X X X X X",
            "X X     X X X X X X X X",
            "X XXXXX X   X X   X X X",
            "X       X X X X X X X X",
            "X XXXXX X X X X X X X X",
            "X X     X X X X X X X X",
            "X X XXX X X X X X X X X",
            "X X   X X X X X X X X X",
            "X XXX X X X X X X X X F" };
        
        String[] mapaStr = {
                "XXXXXXXXXXXXXXXXXXXXXXXXX",
                "S           X     X     X",
                "X XXXXXXXXX X X X X X X X",
                "X         X X X X X X X X",
                "X XXXXXXX X X X X X X X X",
                "X X       X X X X X X X X",
                "X X XXXXX X X X X   X X X",
                "X X X     X X X X X X X X",
                "X X X XXX X X X X X X X X",
                "X X X X   X X X X X X X X",
                "X X X XXXXX X X X X X X X",
                "X X X       X X X X X   X",
                "X X XXXXXXXXX X X X X X X",
                "X X           X X X X X X",
                "X XXXXXXXXXXX X X X X X X",
                "X             X X X X X X",
                "XXXXXXXXXXXXX X X X X X F" };

        mapa = new MapaFX(mapaStr);
        personaje = new PersonajeFX(mapa.getFilInicio(), mapa.getColInicio());
        personaje.setImagen(new Image("ud7/javafxpracticas/mapaV01/img/personaje.png"));
        mapa.dibujarPersonaje(personaje);

        mapa.dibujarImagen(new Image("ud7/javafxpracticas/mapaV01/img/carne.jpg"), 9, 7 );
        mapa.dibujarImagen(new Image("ud7/javafxpracticas/mapaV01/img/carne.jpg"), 12, 15 );



        Scene scene = new Scene(mapa.gridPane);

        scene.setOnKeyPressed(e -> mapa.moverPersonaje(personaje, e.getCode()));

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
