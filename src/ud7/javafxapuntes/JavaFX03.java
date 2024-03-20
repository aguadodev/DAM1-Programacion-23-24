package ud7.javafxapuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFX03 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX03");

        TextField txtNum1 = new TextField();
        TextField txtNum2 = new TextField();

        Label lblResultado = new Label();

        Button btnSumar = new Button("Sumar");
        btnSumar.setOnAction(e -> {
            try {
                Double num1 = Double.valueOf(txtNum1.getText());
                Double num2 = Double.valueOf(txtNum2.getText());

                Double suma = num1 + num2;

                lblResultado.setText(suma.toString());

            } catch (Exception ex) {
                lblResultado.setText("No puedo sumar esos valores. Has usado el punto decimal correctamente?");
            }
            
        });

        VBox vbox = new VBox(txtNum1, txtNum2, btnSumar, lblResultado);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
