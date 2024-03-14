package praiasdegalicia;

public class AppDistancia {
    public static void main(String[] args) {
        // Carga las playas desde el fichero JSON en un array de Praias
        Praia[] praias = Util.importarPraias("praias.json");

        // TODO Resuelve el problema propuesto
        Praia[] praiascercanas = Praia.praiasCercanas(praias, 42.38974, -8.71052, 10);
        System.out.println("PRAIAS MÁS CERCANAS AO IES CHAN DO MONTE (Lat: 42.38974, Lon: -8.71052");
        System.out.println("======================================================================");
        for (int i = 0; i < praiascercanas.length; i++) {
            System.out.println(
                    (i + 1) + ". " + praiascercanas[i].getNome() + " - " + praiascercanas[i].getConcello() + " - " 
                    + (int) Util.distancia(praiascercanas[i].getLat(), praiascercanas[i].getLon(), 42.38974, -8.71052) + " m");
        }

    }
}
