package ud4.praiasdegalicia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class PraiasBD {
    
    public static void main(String[] args) {
        
        Praia[] praias;

        praias = leerPraiasBD();

        for(int i = 0; i < praias.length; i++){
            System.out.println(praias[i].getNome() + " - " + praias[i].getUrlPrediccionMeteogalicia());

            String jsonMeteogalicia = leerUrl(praias[i].getUrlPrediccionMeteogalicia());
            int inicioLat = jsonMeteogalicia.indexOf("lat\":") + 5;
            int finLat = jsonMeteogalicia.indexOf(",", inicioLat);
            String latitud = jsonMeteogalicia.substring(inicioLat, finLat);

            praias[i].setLat(Double.valueOf(null));
            praias[i].setLon(Double.valueOf(null));

        }

    }


    private static Praia[] leerPraiasBD(){
        Praia[] praias = new Praia[0];

        try (Connection connection = Conexion.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM praia");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Praia praia = new Praia();
                praia.setId(resultSet.getInt("id"));
                praia.setNome(resultSet.getString("nome"));
                praia.setConcello(resultSet.getString("concello"));
                praia.setProvincia(resultSet.getString("provincia"));
                praia.setLat(resultSet.getDouble("lat"));
                praia.setLon(resultSet.getDouble("lon"));                
                
                praias = Arrays.copyOf(praias, praias.length + 1);
                praias[praias.length - 1] = praia;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return praias;        

    }

    public static String leerUrl(String url) {
        String contenido = "";

        // Configuración del proxy del sistema
        System.setProperty("java.net.useSystemProxies", "true");

        try {
            URI uri = new URI(url);
            URLConnection conexion = uri.toURL().openConnection();
            conexion.setRequestProperty("Accept-Language", "es");
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));

            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido += linea + "\n";
            }
            lector.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
        return contenido;
    }


}
