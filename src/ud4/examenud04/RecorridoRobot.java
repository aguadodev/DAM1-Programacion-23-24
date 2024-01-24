package ud4.examenud04;

public class RecorridoRobot {
    static String[] mapa = {
            "  Z       ",
            " *        ",
            "  *  *    ",
            "          ",
            " A        "
    };

    public static void main(String[] args) {
        System.out.println(recorridoRobot(mapa, "AALARAARAA"));
        System.out.println(recorridoRobot(mapa, "RAALAAAALA"));
        System.out.println(recorridoRobot(mapa, "ARALA"));
        System.out.println(recorridoRobot(mapa, "LAA"));

    }

    static boolean recorridoRobot(String[] mapa, String instrucciones) {
        boolean recorridoOk = true;

        // Obtiene la casilla de Salida
        int filaA = -1, colA = -1;
        int i = 0;
        while (i < mapa.length && filaA == -1) {
            colA = mapa[i].indexOf('A');
            if (colA != -1)
                filaA = i;
            else
                i++;
        }

        int filaRobot = filaA;
        int colRobot = colA;
        // Recorre y ejecuta las instrucciones
        char orientacionRobot = 'U'; // La orientación puede ser 'U'p, 'D'own, 'L'eft, y 'R'ight
        i = 0;
        while (i < instrucciones.length() && recorridoOk) {
            switch (instrucciones.charAt(i)) {
                case 'A':
                    switch (orientacionRobot) {
                        case 'U':
                            filaRobot--;
                            if (filaRobot < 0)
                                recorridoOk = false;
                            break;
                        case 'R':
                            colRobot++;
                            if (colRobot >= mapa[filaRobot].length())
                                recorridoOk = false;
                            break;
                        case 'D':
                            filaRobot++;
                            if (filaRobot >= mapa.length)
                                recorridoOk = false;
                            break;
                        case 'L':
                            colRobot--;
                            if (colRobot < 0)
                                recorridoOk = false;
                            break;
                    }

                    break;
                case 'R':
                    switch (orientacionRobot) {
                        case 'U' -> orientacionRobot = 'R';
                        case 'R' -> orientacionRobot = 'D';
                        case 'D' -> orientacionRobot = 'L';
                        case 'L' -> orientacionRobot = 'U';
                    }
                    break;
                case 'L':
                    switch (orientacionRobot) {
                        case 'U' -> orientacionRobot = 'L';
                        case 'R' -> orientacionRobot = 'U';
                        case 'D' -> orientacionRobot = 'R';
                        case 'L' -> orientacionRobot = 'D';
                    }
                    break;
            }
            // Si pisa una mina
            if (recorridoOk && mapa[filaRobot].charAt(colRobot) == '*')
                recorridoOk = false;

            i++;
        }

        // Si al terminar un recorrido válido no está en la casilla de llegada
        if (recorridoOk && mapa[filaRobot].charAt(colRobot) != 'Z')
            recorridoOk = false;

        return recorridoOk;
    }

}
