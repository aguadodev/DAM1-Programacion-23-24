package ud7.javafxpracticas.mapaV03;

import java.io.FileReader;
import java.io.BufferedReader;
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
     * NUEVO: Carga un mapa desde un fichero de texto.
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

    public boolean esMuro(int i, int j) {
        return mapa[i][j] == 'X';
    }

    public boolean esInicio(int i, int j) {
        return i == filInicio && j == colInicio;
    }

    public boolean esFin(int i, int j) {
        return i == filFin && j == colFin;
    }

    public int getFilInicio() {
        return filInicio;
    }

    public int getColInicio() {
        return colInicio;
    }

}
