package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFX01 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hola Mundo!!");
        
        Button btn1 = new Button("Púlsame");
        
        EventHandler<ActionEvent> manejador = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón pulsado!");
            }
        };

        btn1.setOnAction(manejador);

        Scene scene = new Scene(btn1);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
}
