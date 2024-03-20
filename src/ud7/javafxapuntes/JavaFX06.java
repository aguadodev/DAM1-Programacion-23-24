package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX06 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX06");


        TextField textField = new TextField("Texto a añadir");

        TextArea textArea = new TextArea();

        Button button = new Button("Añadir");

        VBox vbox = new VBox(textField, textArea, button);

        button.setOnAction(e -> {
            textArea.setText(textArea.getText() + textField.getText() + "\n");
        });

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
