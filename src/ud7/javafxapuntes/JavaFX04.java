package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX04 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX04");

        TextField txtColor = new TextField("Escribe un color");

        Button btn = new Button("Cambiar color");

        VBox vbox = new VBox(txtColor, btn);

        btn.setOnAction(e -> vbox.setStyle("-fx-background-color: " + txtColor.getText()));

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
