package ud7.javafxpracticas.mapaV02;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AppLaberintoV02 extends Application {
    MapaFX mapa;
    PersonajeFX personaje;
    private int platos = 0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("AppLaberinto");
        
        String[] mapaStr = {
                "XXXXXXXXXXXXXXXXXXXXXXXXX",
                "S                 X     X",
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

        // Generar y dibujar en el mapa N platos de carne
        mapa.dibujarImagen(new Image("ud7/javafxpracticas/mapaV01/img/carne.jpg"), 9, 7 );

        // Añadir o modificar al manejador de evento para detectar:
        // 1. cuando se pisa un plato de carne
        // 2. cuando se llega a la casilla de Fin

        Scene scene = new Scene(mapa.gridPane);

        scene.setOnKeyPressed(e -> mapa.moverPersonaje(personaje, e.getCode()));
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (true/* REVISAR CONDICIÓN */) {
                System.out.println("¡Has pisado un plato de carne!");
                platos++;
                // Añadir Lógica
                // Cuando un contador llegue a tres, 
                // mostrar mensaje de victoria en una ventana nueva
                if (platos > 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("¡Has ganado!");
                    alert.setHeaderText("¡Enhorabuena!");
                    alert.setContentText("¡Has encontrado los tres platos de carne!");
                    alert.showAndWait();
                    // Al cerrar la ventana, cerrar la aplicación
                    primaryStage.close();                     
                }
           

            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
