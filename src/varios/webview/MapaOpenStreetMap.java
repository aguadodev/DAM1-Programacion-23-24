package varios.webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapaOpenStreetMap extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea un WebView
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Carga el mapa de OpenStreetMap
        webEngine.load(getClass().getResource("mapa.html").toExternalForm());

        // Crea una pila de JavaFX y agrega el WebView
        StackPane root = new StackPane();
        root.getChildren().add(webView);

        // Crea la escena y muestra la ventana
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mapa OpenStreetMap en JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
