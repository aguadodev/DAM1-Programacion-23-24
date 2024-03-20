package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX05 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX05");

        ComboBox<String> cmbColor = new ComboBox<>();
        cmbColor.getItems().add("red");
        cmbColor.getItems().add("blue");
        cmbColor.getItems().add("green");

        VBox vbox = new VBox(cmbColor);

        cmbColor.setOnAction(e -> vbox.setStyle("-fx-background-color: " + cmbColor.getValue()));

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
