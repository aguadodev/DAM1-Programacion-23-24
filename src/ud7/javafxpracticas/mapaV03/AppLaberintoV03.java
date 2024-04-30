package ud7.javafxpracticas.mapaV03;

import java.time.LocalTime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AppLaberintoV03 extends Application {
    // Atributos de la aplicación JavaFX
    MapaFX mapa;
    PersonajeFX personaje;
    MenuBar menuBar;
    Label barraEstado;
    Image IMAGE_CARNE = new Image("ud7/javafxpracticas/mapaV03/img/carne.jpg");
    Image IMAGE_PERSONAJE = new Image("ud7/javafxpracticas/mapaV03/img/personaje.png");

    // Atributos principales del juego
    int platosRecogidos = 0;
    boolean[][] casillasConCarne;
    LocalTime horaInicio;
    LocalTime horaFin;

    String[] mapaStr = {
            "XXXXXXXXXXXXXXXXXXXXXXXXX",
            "S                 X     X",
            "X XXXXXXXXX X X X X X X X",
            "X         X X X X X X X X",
            "X XXXXXXX X X X X X X X X",
            "X X       X X X X X X X X",
            "X X XXXXX X X X X   X X X",
            "X X X     X X X X X X X X",
            "X X X XXX X X X X X X X X",
            "X X X X   X X X X X X X X",
            "X X X XXXXX X X X X X X X",
            "X X X       X X X X X   X",
            "X X XXXXXXXXX X X X X X X",
            "X X           X X X X X X",
            "X XXXXXXXXXXX X X X X X X",
            "X             X X X X X X",
            "XXXXXXXXXXXXX X X X X X F" };

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AppLaberinto");

        // Inicializa un nuevo juego
        mapa = new MapaFX(mapaStr);
        iniciarJuego(primaryStage);

        // Mostrar la ventana
        primaryStage.show();
    }

    /**
     * Inicializa un nuevo juego.
     * 
     * @param primaryStage Escenario principal
     */
    private void iniciarJuego(Stage stage) {

        // Crear y dibujar personaje
        personaje = new PersonajeFX(mapa.getFilInicio(), mapa.getColInicio());
        personaje.setImagen(IMAGE_PERSONAJE);
        mapa.dibujarPersonaje(personaje);

        // Generar y dibujar en el mapa N platos de carne
        // Genera un mapa con un 10% de casillas con carne
        casillasConCarne = casillasConCarne(mapa, mapa.contarCasillasVacias() / 10);
        mapa.dibujarImagen(IMAGE_CARNE, casillasConCarne);

        // Guarda la hora de inicio
        horaInicio = LocalTime.now();
        platosRecogidos = 0;

        // NUEVO: Menú y barra de estado
        menuBar = crearMenuBar(stage);
        barraEstado = new Label("Platos recogidos: " + platosRecogidos);

        Scene scene = new Scene(new VBox(menuBar, mapa.gridPane, barraEstado));

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            // Mueve el personaje en la dirección indicada por la tecla pulsada
            mapa.moverPersonaje(personaje, e.getCode());

            int f = personaje.filJugador;
            int c = personaje.colJugador;
            System.out.println("Personaje en: " + f + ", " + c);

            // Comprueba si el personaje está en una casilla con carne
            if (casillasConCarne[f][c]) {
                System.out.println("¡Has recogido un plato de carne en " + f + ", " + c);
                platosRecogidos++;
                casillasConCarne[f][c] = false;
                // NUEVO: Actualiza la barra de estado
                barraEstado.setText("Platos recogidos: " + platosRecogidos);
            }

            // Comprueba si el personaje ha llegado al final del laberinto
            if (mapa.esFin(f, c)) {
                mostrarFinJuego();
                // Cerrar la aplicación
                stage.close();
            }
        });

        stage.setScene(scene);

    }

    /**
     * Muestra un diálogo con información de fin de juego.
     */
    private void mostrarFinJuego() {
        horaFin = LocalTime.now();
        long segundosTranscurridos = horaFin.toSecondOfDay() - horaInicio.toSecondOfDay();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¡Has ganado!");
        alert.setHeaderText("¡Enhorabuena!");
        alert.setContentText("¡Has recogido " + platosRecogidos + " platos de carne! \n" + "Has tardado "
                + segundosTranscurridos + " segundos en llegar al final.");

        alert.showAndWait();
    }

    /**
     * Crear un menú de opciones.
     * 
     * @param primaryStage Escenario principal
     * @return Menú principal
     */
    private MenuBar crearMenuBar(Stage primaryStage) {
        MenuItem menuItemCargarMapa = new MenuItem("Cargar Mapa");
        menuItemCargarMapa.setOnAction(e -> cargarMapa(primaryStage));

        MenuItem menuItemCargarPartida = new MenuItem("Cargar Partida");
        MenuItem menuItemGuardarPartida = new MenuItem("Guardar Partida");
        Menu menuArchivo = new Menu("Archivo");
        menuArchivo.getItems().addAll(menuItemCargarMapa, menuItemCargarPartida, menuItemGuardarPartida);
        MenuItem menuItemAcercaDe = new MenuItem("Acerca de...");
        menuItemAcercaDe.setOnAction(e -> mostrarAcercaDe());
        Menu menuAyuda = new Menu("Ayuda");
        menuAyuda.getItems().add(menuItemAcercaDe);
        return new MenuBar(menuArchivo, menuAyuda);
    }

    /**
     * Carga un mapa desde un fichero.
     * 
     * @param stage Escenario principal
     */
    private void cargarMapa(Stage stage) {
        // Cargar un mapa desde un fichero
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir mapa");
        String fichero = fileChooser.showOpenDialog(stage).getAbsolutePath();
        String[] mapaStrAux = Mapa.cargarMapaStr(fichero);

        // Inicializa un nuevo juego
        mapa = new MapaFX(mapaStrAux);
        iniciarJuego(stage);
    }

    /**
     * Muestra un diálogo con información sobre la aplicación.
     */
    private void mostrarAcercaDe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("AppLaberinto v0.3");
        alert.setContentText("Práctica de JavaFX\n" + "Autor: Óscar" + "Fecha: 24/4/2024");
        alert.showAndWait();
    }

    /**
     * Genera una matriz booleana con valores true donde aleatoriamente se han
     * distribuido numPlatos de carne.
     * TODO: Incorporar este método a la clase Mapa
     * 
     * @param m         Mapa
     * @param numPlatos Número de platos de carne
     * @return Matriz booleana con valores true en las casillas con plato de carne
     */
    static boolean[][] casillasConCarne(Mapa m, int numPlatos) {
        boolean[][] casillasConCarne = new boolean[m.numFil][m.numCol];
        while (numPlatos > 0) {
            int f = (int) (Math.random() * m.numFil);
            int c = (int) (Math.random() * m.numCol);
            if (m.esVacia(f, c) && casillasConCarne[f][c] == false) {
                casillasConCarne[f][c] = true;
                numPlatos--;
            }
        }
        return casillasConCarne;
    }

}
