package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.TreeSet;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class RecordsController implements Initializable {

    @FXML
    Label recordsLabel;

    @FXML
    private void cerrar() {
        // Terminar Juego
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Carga los récords
        Collection<Record> records = new TreeSet<>();
        try (FileReader file = new FileReader("records.csv")) {
            BufferedReader in = new BufferedReader(file);
            String linea = in.readLine();
            while (linea != null) {
                String[] campos = linea.split(",");
                records.add(new Record(campos[0], Integer.parseInt(campos[1])));
                linea = in.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

        // Crea el nuevo Récord
        Record recordJuego = new Record(App.p.getNombre(), App.p.getExperiencia());
        records.add(recordJuego);

        // Mostrar Récords
        Iterator<Record> it = records.iterator();
        String str = "";
        int i = 1;
        while (it.hasNext()) {
            Record r = it.next();
            if (r.equals(recordJuego))
                str += "-> "; // Resalta el récord del juego actual
            str += i + ". " + r.nombre + " - " + r.puntos + "\n";
            i++;
        }
        recordsLabel.setText(str);

        // Guarda el fichero de Récords Actualizado
        try (FileWriter file = new FileWriter("records.csv")) {
            BufferedWriter out = new BufferedWriter(file);
            Iterator<Record> it2 = records.iterator();
            String strFile = "";
            while (it2.hasNext())
                strFile += it2.next() + "\n";
            out.write(strFile);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

// Clase privada auxiliar para gestionar los récords
class Record implements Comparable<Record> {
    String nombre;
    Integer puntos;

    public Record(String nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre + "," + puntos;
    }

    @Override
    public int compareTo(Record o) {
        return puntos.compareTo(o.puntos);
    }

}