package ud4.praiasdegalicia;

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

}
