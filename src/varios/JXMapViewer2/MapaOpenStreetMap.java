package varios.JXMapViewer2;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactory;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MapaOpenStreetMap extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea un JXMapViewer
        JXMapViewer mapViewer = new JXMapViewer();

        // Configura el proveedor de mapas OpenStreetMap
        TileFactoryInfo info = new TileFactoryInfo(1, 17, 17, 256, true, true, //Slippy Map
            "https://tile.openstreetmap.org/", "x", "y", "z") {
                public String getTileUrl(int x, int y, int zoom) {
                    zoom = 17 - zoom;
                    String url = this.baseURL + zoom + "/" + x + "/" + y + ".png";
                    return url;
                }
        };
        
        TileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        // Envuelve el JXMapViewer en un nodo SwingNode
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(mapViewer);

        // Crea una pila de JavaFX y agrega el nodo SwingNode
        StackPane root = new StackPane();
        root.getChildren().add(swingNode);

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
