package ud8.jpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registro de usuario");
        primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("Register.fxml"))));
        primaryStage.show();
    }
}
