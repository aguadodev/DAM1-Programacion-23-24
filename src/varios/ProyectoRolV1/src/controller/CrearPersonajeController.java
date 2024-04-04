package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.w3c.dom.css.CSSMediaRule;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Personaje;

public class CrearPersonajeController implements Initializable{

    @FXML
    Label lblAtributos;
    
    @FXML
    ComboBox<Personaje.Raza> cmbRaza;

    @FXML
    TextField txtNombre;

    Personaje p;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Crea un personaje
        p = new Personaje("Sin nombre", "HUMANO");
        App.p = p; // Copia la referencia del personaje en la variable estática de la App

        // Muestra en la vista los datos del personaje creado
        lblAtributos.setText("Atributos Físicos del Personaje: \n" + 
        "Fuerza: " + p.getFuerza() + "\n" +
        "Agilidad: " + p.getAgilidad() + "\n" +
        "Constitución: " + p.getConstitucion() + "\n" +
        "Puntos de Vida: " + p.getPuntosVida() + "\n" +
        "Puntos de Experiencia: " + p.getExperiencia() + "\n" +
        "Nivel: " + p.getNivel() + "\n"
        );        

        cmbRaza.getItems().addAll(Personaje.Raza.values());
        cmbRaza.setValue(Personaje.Raza.HUMANO);
    }

    public void crearPersonaje() {
        p.setNombre(txtNombre.getText());
        p.setRaza(cmbRaza.getValue());
        p.mostrar();
        App.cargarEscena("Mapa");
     }
    


}
