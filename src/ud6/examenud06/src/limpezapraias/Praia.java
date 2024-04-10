package limpezapraias;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Praia implements Comparable<Praia>, Serializable {
    private int id;
    private String nome;
    private String concello;
    private String provincia;
    private double lat;
    private double lon;

    /**
     * CONSTRUCTORES
     */
    public Praia() {
    }

    public Praia(int id) {
        this.id = id;
    }

    public Praia(int id, String nome, String concello, String provincia) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
    }

    public Praia(int id, String nome, String concello, String provincia, double lat, double lon) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * GETTERS Y SETTERS
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConcello() {
        return concello;
    }

    public void setConcello(String concello) {
        this.concello = concello;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * MÉTODOS IMPRESIÓN
     */
    public static void imprimirLista(Praia[] praias, int i) {
        for (int j = 0; j < i; j++)
            praias[j].mostrarDetalles();
    }

    public void mostrarDetalles() {
        String str = id + " - " + nome + " - " + concello + " - " + provincia + " - ("
                + lat + ", " + lon + ")";
        System.out.println(str);
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + concello + ")";
    }

    /**
     * MÉTODOS DE COMPARACIÓN Y ORDENACIÓN
     */
    @Override
    public int compareTo(Praia o) {
        return id - o.id;
    }

    static Praia[] sortLatitudNorteSur(Praia[] p) {
        Arrays.sort(p, new Comparator<Praia>() {

            @Override
            public int compare(Praia o1, Praia o2) {
                return o1.lat > o2.lat ? -1 : o1.lat < o2.lat ? 1 : 0;
            }
        });

        return p;
    }

    static Praia[] sortProvinciaConcelloNome(Praia[] p) {
        Comparator<Praia> cProvincia = new Comparator<>() {
            @Override
            public int compare(Praia o1, Praia o2) {
                return o1.provincia.compareTo(o2.provincia);
            }
        };

        Comparator<Praia> cConcello = new Comparator<>() {
            @Override
            public int compare(Praia o1, Praia o2) {
                return o1.concello.compareTo(o2.concello);
            }
        };

        Comparator<Praia> cNome = new Comparator<>() {
            @Override
            public int compare(Praia o1, Praia o2) {
                return o1.nome.compareTo(o2.nome);
            }
        };

        Arrays.sort(p, cProvincia.thenComparing(cConcello).thenComparing(cNome));

        return p;
    }

    public static Praia[] praiasCercanas(Praia[] praias, double lat, double lon, int n) {

        Comparator<Praia> cDistancia = new Comparator<>() {
            @Override
            public int compare(Praia o1, Praia o2) {
                Double dPlaya1 = Util.distancia(lat, lon, o1.lat, o1.lon);
                Double dPlaya2 = Util.distancia(lat, lon, o2.lat, o2.lon);
                return dPlaya1.compareTo(dPlaya2);
            }
        };

        Arrays.sort(praias, cDistancia);

        return Arrays.copyOf(praias, n);
    }

}
