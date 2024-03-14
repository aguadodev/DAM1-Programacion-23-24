package praiasdegalicia;

public class AppOrden {
    public static void main(String[] args) {
        // Carga las playas desde el fichero JSON en un array de Praias
        Praia[] praias = Util.importarPraias("praias.json");

        // TODO Resuelve el problema propuesto
        praias = Praia.sortLatitudNorteSur(praias);
        System.out.println("PRAIAS ORDENADAS POR LATITUD (de norte a sur)");
        System.out.println("=============================================");
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    (i + 1) + ". " + praias[i].getNome() + " - " + praias[i].getLat() + " - " + praias[i].getConcello());
        }

        System.out.println();


        praias = Praia.sortProvinciaConcelloNome(praias);
        System.out.println("PRAIAS ORDENADAS POR PROVINCIA, CONCELLO, NOME");
        System.out.println("==============================================");
        for (int i = 0; i < praias.length; i++) {
            System.out.println(
                    (i + 1) + ". " + praias[i].getProvincia() + " - " + praias[i].getConcello() + " - " + praias[i].getNome());
        }

        // ...
    }
}
