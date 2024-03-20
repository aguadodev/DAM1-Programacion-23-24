package ud7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX01
 */
public class JavaFX01 extends Application {

    int pulsaciones = 0;
    Button btn1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX01");

        btn1 = new Button("Púlsame!");
        btn1.autosize();
        btn1.setAlignment(Pos.BASELINE_CENTER);
        btn1.setStyle("-fx-font-size: 20; -fx-background-color: #ff0000; -fx-text-fill: #ffffff;");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pulsaciones++;
                String str = "¡Me has pulsado " + pulsaciones + (pulsaciones > 1 ? " veces" : " vez!");
                str += "\n¡Púlsame otra vez!";
                btn1.setText(str);
            }
        });

        primaryStage.setScene(new javafx.scene.Scene(btn1, 300, 250));

        primaryStage.show();
    }
}