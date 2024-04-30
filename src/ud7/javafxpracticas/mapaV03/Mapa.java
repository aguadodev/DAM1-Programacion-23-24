package ud7.javafxpracticas.mapaV03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Mapa {
    protected char[][] mapa;

    protected int numFil;
    protected int numCol;

    protected int filInicio;
    protected int colInicio;

    protected int filFin;
    protected int colFin;

    public Mapa(int numFil, int numCol) {
        this.numFil = numFil;
        this.numCol = numCol;

        this.mapa = new char[numFil][numCol];

        for (int i = 0; i < numFil; i++)
            Arrays.fill(mapa[i], ' ');
    }

    /**
     * Crea un mapa a partir de un array de Strings.
     * 
     * @param mapaStr Array de Strings con el mapa
     */
    public Mapa(String[] mapaStr) {
        this.numFil = mapaStr.length;
        this.numCol = mapaStr[0].length();
        this.mapa = new char[numFil][numCol];

        for (int i = 0; i < numFil; i++)
            for (int j = 0; j < numCol; j++) {
                switch (mapaStr[i].charAt(j)) {
                    case 'X' -> {
                        mapa[i][j] = 'X';
                    }
                    case ' ' -> {
                        mapa[i][j] = ' ';
                    }
                    case 'S' -> {
                        mapa[i][j] = ' ';
                        filInicio = i;
                        colInicio = j;
                    }
                    case 'F' -> {
                        mapa[i][j] = ' ';
                        filFin = i;
                        colFin = j;
                    }
                    default -> {
                        mapa[i][j] = ' ';
                    }
                }
            }
    }

    /**
     * Carga un mapa desde un fichero de texto.
     * 
     * @param fichero Nombre del fichero
     * @return Mapa en formato de matriz de caracteres
     */
    public static String[] cargarMapaStr(String fichero) {
        String[] mapaStr = null;
        try (BufferedReader in = new BufferedReader(new FileReader(fichero))) {
            String linea = in.readLine();
            while (linea != null) {
                if (mapaStr == null)
                    mapaStr = new String[1];
                else
                    mapaStr = Arrays.copyOf(mapaStr, mapaStr.length + 1);
                mapaStr[mapaStr.length - 1] = linea;
                linea = in.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el fichero");
        }
        return mapaStr;
    }

    // MÉTODOS QUE COMPRUEBAN EL ESTADO DE LAS CASILLAS

    public boolean esVacia(int f, int c) {
        return mapa[f][c] == ' ';
    }

    public boolean esMuro(int f, int c) {
        return mapa[f][c] == 'X';
    }

    public boolean esInicio(int f, int c) {
        return f == filInicio && c == colInicio;
    }

    public boolean esFin(int f, int c) {
        return f == filFin && c == colFin;
    }

    /**
     * Cuenta las casillas vacías de un mapa.
     * 
     * @return Número de casillas vacías
     */
    public int contarCasillasVacias() {
        int contador = 0;
        for (int i = 0; i < numFil; i++)
            for (int j = 0; j < numCol; j++)
                if (esVacia(i, j))
                    contador++;
        return contador;

    }

    // GETTERS Y SETTERS

    public int getFilInicio() {
        return filInicio;
    }

    public int getColInicio() {
        return colInicio;
    }

}
