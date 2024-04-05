package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Ejemplo que muestra la secuencia de captura y propagación de un evento 
 * y la ejecución de los filtros de evento (EventFilter) y 
 * manejadores de evento (EventHandler) correspondientes.
 * La secuencia se puede detener ejecutando el método consume() del objeto Event.
 */
public class EjemploEventFilterHandler extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("Button");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Button Event Handler"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> System.out.println("StackPane Event Filter"));
        // Prueba a modificar el filtro añadiendo consume() para ver cómo se detiene la propagación del evento.

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Manejo de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
