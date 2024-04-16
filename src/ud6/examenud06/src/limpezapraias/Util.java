package limpezapraias;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.google.gson.Gson;

public class Util {
    /**
     * Importa un array de Praias desde un fichero JSON
     * 
     * @param fichero Ruta del fichero JSON
     * @return Array de Praias
     */
    public static Praia[] importarPraias(String fichero) {
        Gson gson = new Gson();

        String json = Util.readFileToString(fichero); // contenido JSON;
        return gson.fromJson(json, Praia[].class);
    }

    /**
     * Lee y carga el contenido de un fichero de texto a un String (fuente OpenAI)
     * 
     * @param filePath Ruta del fichero
     * @return Contenido del fichero como un String
     */
    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            // Creamos un objeto FileReader que nos permitirá leer el fichero
            FileReader reader = new FileReader(filePath);

            // Creamos un buffer para leer el fichero de forma más eficiente
            BufferedReader buffer = new BufferedReader(reader);

            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }

            // Cerramos el buffer y el fichero
            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
            // e.printStackTrace();
        }

        // Devolvemos el contenido del fichero como un String
        return fileContent.toString();
    }

    /**
     * Calcula la distancia en metros entre dos puntos geográficos
     * 
     * @param lat1 Latitud del punto 1
     * @param lon1 Longitud del punto 1
     * @param lat2 Latitud del punto 2
     * @param lon2 Longitud del punto 2
     * @return distancia en metros
     */
    public static double distancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2)
                        * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;
        distance = Math.pow(distance, 2);
        return Math.sqrt(distance);
    }

    public static <T> void escribirFichero(T datos, String fichero) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fichero))) {
            out.writeObject(datos);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static <T> T leerFichero(String fichero, T datos) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero))) {
            datos = (T) in.readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        return datos;
    }

}
