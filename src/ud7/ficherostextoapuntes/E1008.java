package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class E1008 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src\\ud7\\ficherostextoapuntes"));

        File file = fileChooser.showOpenDialog(primaryStage);

        String outFile = file.getParent() + "\\copia_de_" + file.getName();

        try (BufferedReader in = new BufferedReader(new FileReader(file));
             BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {
            String linea = in.readLine();
            while (linea != null) {
                out.write(linea);
                out.newLine();
                linea = in.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
