package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EjemplosEventos extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplos de Eventos");

        // Eventos de ventana
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING, e -> System.out.println("WINDOW_SHOWING"));
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN, e -> System.out.println("WINDOW_SHOWN"));
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e -> System.out.println("WINDOW_CLOSE_REQUEST"));
        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDING, e -> System.out.println("WINDOW_HIDING"));
        primaryStage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e -> System.out.println("WINDOW_HIDDEN"));

        TextField textField = new TextField();

        textField
                .setOnKeyPressed((KeyEvent evento) -> System.out.println("Se ha pulsado la tecla " + evento.getCode()));

        Button button = new Button("Button");

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("MOUSE_CLICKED - " + e));

        vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("MOUSE_CLICKED - " + e));

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("MOUSE_CLICKED - " + e));

        primaryStage.show();
    }

}
