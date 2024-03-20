package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX01
 */
public class JavaFX01Bis extends Application {

    static int pulsaciones = 0;
    static Button btn1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX01");

        btn1 = new Button("Púlsame!");
        btn1.autosize();

        btn1.setStyle("-fx-font-size: 20; -fx-background-color: #ff0000; -fx-text-fill: #ffffff;");

        btn1.setOnAction(e -> botonpulsado());

        primaryStage.setScene(new Scene(btn1, 300, 250));

        primaryStage.show();
    }

    
    private void botonpulsado() {
        pulsaciones++;
        String str = "¡Me has pulsado " + pulsaciones + (pulsaciones > 1 ? " veces" : " vez!");
        str += "\n¡Púlsame otra vez!";
        btn1.setText(str);
    }
}

 