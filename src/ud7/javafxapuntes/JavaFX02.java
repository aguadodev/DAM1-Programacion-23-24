package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX02 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX02");

        TextField txtText = new TextField("Escribe algo...");

        Label label = new Label();

        Button btnBoton = new Button("Imprimir");
        btnBoton.setOnAction(e -> label.setText(txtText.getText()));

        VBox vbox = new VBox(txtText, btnBoton, label);

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
    
}
