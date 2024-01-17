package ud4.practicas;


import java.util.Scanner;

/**
 *
 * @author Óscar Núñez Aguado <aguado@edu.xunta.es>
 */
public class Buscaminas {
    // Declaración de variables y constantes de clase
    static final int FILAS = 20;
    static final int COLUMNAS = 20;
    static final int NUM_MINAS = 4;
    static boolean[][] tableroMinas = new boolean[FILAS][COLUMNAS];
    static char[][] tableroJuego = new char[FILAS][COLUMNAS];
    static int numMarcas = 0; // número de minas marcadas por el jugador
    // Condiciones de salida del juego
    static boolean opcionSalir = false;    // El jugador introdujo la opción de Salir?  
    static boolean minaDestapada = false;  // El jugador destapó una mina?   
    static boolean minasMarcadas = false;  // El jugador marcó correctamente todas las minas?
        
    public static void main(String[] args) {       
        // Declaración de variables y constantes
        int fila, columna;
        
        iniciarTableroMinas();
        iniciarTableroJuego();

        do {
            imprimirTableroJuego(); 
            //imprimirTableroMinas(); // Trampa => BORRAR
            imprimirMenu();
            switch (leerOpcion()){
                case 0: 
                    opcionSalir = true;
                    break;
                case 1: // Destapar Casilla
                    fila = leerFila();
                    columna = leerColumna();                    
                    destaparCasilla(fila, columna);                           
                    break;
                case 2: // Marcar Casilla
                    fila = leerFila();
                    columna = leerColumna();
                    marcarCasilla(fila, columna);
                    break;
                case 3: // Desmarcar Casilla
                    fila = leerFila();
                    columna = leerColumna();
                    desmarcarCasilla(fila, columna);
                    break;
            }            
        }while (!opcionSalir && !minaDestapada && !minasMarcadas);

        imprimirFinJuego();
        
         
    }

    //... Otras funciones

    static void destaparCasilla(int f, int c){
        // Comprueba que la casilla está tapada
        if (tableroJuego[f][c] == '-') {
            if (tableroMinas[f][c]) {
                // Si destapa una mina pierde
                minaDestapada = true;
            } else {
                // Calcular y mostrar minas adyacentes
                int minasAdyacentes = minasAdyacentes(f, c);
                tableroJuego[f][c] = (char)(48 + minasAdyacentes);
                if (minasAdyacentes == 0) {
                    if (f>0 && c>0) destaparCasilla(f-1, c-1);
                    if (f>0) destaparCasilla(f-1, c);
                    if (f>0 && c<(COLUMNAS-1)) destaparCasilla(f-1, c+1);
                    if (c>0) destaparCasilla(f, c-1);
                    if (c<(COLUMNAS-1)) destaparCasilla(f, c+1);
                    if (f<(FILAS-1) && c>0) destaparCasilla(f+1, c-1);
                    if (f<(FILAS-1)) destaparCasilla(f+1, c);
                    if (f<(FILAS-1) && c<(COLUMNAS-1)) destaparCasilla(f+1, c+1);
                }            
            }            
        }
    }
    
    static int minasAdyacentes(int f, int c){
        int numMinas = 0;        
        
        if (f>0 && c>0 && tableroMinas[f-1][c-1]) numMinas++;
        if (f>0 && tableroMinas[f-1][c]) numMinas++;
        if (f>0 && c<(COLUMNAS-1) && tableroMinas[f-1][c+1]) numMinas++;
        
        if (c>0 && tableroMinas[f][c-1]) numMinas++;
        if (c<(COLUMNAS-1) && tableroMinas[f][c+1]) numMinas++;
        
        if (f<(FILAS-1) && c>0 && tableroMinas[f+1][c-1]) numMinas++;
        if (f<(FILAS-1) && tableroMinas[f+1][c]) numMinas++;
        if (f<(FILAS-1) && c<(COLUMNAS-1) && tableroMinas[f+1][c+1]) numMinas++;
        
        return numMinas;
    }
    
    
static void imprimirFinJuego() {
    System.out.println("");
    imprimirTableroMinas();

    if (minasMarcadas){
        System.out.println("\nENHORABUENA!!! HAS DESCUBIERTO TODAS LAS MINAS!!!");
    } else if (minaDestapada) {
        System.out.println("\nESTÁS MUERT@!!! HAS DESTAPADO UNA MINA!!!");            
    } else if (opcionSalir){
        System.out.println("\nHAS ELEGIDO SALIR...:( TE HAS ABURRIDO MUCHO?? ");
    }          
}    

    static int leerFila(){
        int fila = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.print("Fila: ");
            fila = sc.nextInt();
        } while(fila < 0 || fila >= FILAS);
        
        return fila;
    }

    
    static int leerColumna(){
        int columna = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.print("Columna: ");
            columna = sc.nextInt();
        } while(columna < 0 || columna >= COLUMNAS);
                
        return columna;
    }    

    static void desmarcarCasilla(int f, int c){
        if (tableroJuego[f][c] == 'M'){
            tableroJuego[f][c] = '-';
        }
        numMarcas--;
    }

    
    static void marcarCasilla(int f, int c){
        // Comprueba que la casilla está tapada
        if (tableroJuego[f][c] == '-') {
            // Comprueba si el jugador ha usado todas las marcas
            if (numMarcas == NUM_MINAS) {
                System.out.println("Lo siento ya has usado todas las marcas.");
            } else {
                // Marcar 'M' en el tablero                
                tableroJuego[f][c] = 'M'; 
                numMarcas++;

                if (numMarcas == NUM_MINAS) {
                    minasMarcadas = comprobarMarcas();
                }            
            }            
        }
    }

static boolean comprobarMarcas() {
    boolean marcasOk = true;
    
    int i = 0;
    while (i < FILAS && marcasOk) {
        int j = 0;
        while (j < COLUMNAS && marcasOk) {
            if (tableroMinas[i][j] && tableroJuego[i][j] != 'M')
                marcasOk = false;
            j++;
        }
        i++;
    }
    
    /*for(int i = 0; i < FILAS; i++)
        for(int j = 0; j < COLUMNAS; j++)
            if (tableroMinas[i][j] && tableroJuego[i][j] != 'M')
                marcasOk = false;*/
    
    return marcasOk;
}
    
    static void iniciarTableroJuego(){
        // Inicializar tablero a false (no es necesario en Java)
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)        
                tableroJuego[i][j] = '-';       
    }

    
    static void imprimirTableroJuego(){
        
        for(int j = 0; j < COLUMNAS; j++){
            if (j==0) System.out.print("   ");
            System.out.print(j % 10 + " ");
        }
        System.out.println("");
            
        for(int i = 0; i < FILAS; i++){
            System.out.print(i % 10 + ": ");
            
            for(int j = 0; j < COLUMNAS; j++)
                System.out.print(tableroJuego[i][j] + " ");
            System.out.println("");
        }            
    }    

    static void imprimirMenu() {
        System.out.println("\nMenú");
        System.out.println("1. Destapar casilla");
        System.out.println("2. Marcar mina");
        System.out.println("3. Desmarcar mina");        
        System.out.println("0. SALIR");
    }
    
    
    static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Opción: ");
        
        return sc.nextInt();
    }
    
    
    static void iniciarTableroMinas(){
        int f, c;
        
        // Inicializar tablero a false (no es necesario en Java)
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)        
                tableroMinas[i][j] = false;
        
        // Coloca cada mina
        for (int i = 0; i < NUM_MINAS; i++) {
            // Genera coordenadas aleatorias mientras la casilla tenga mina.
            do {
                f = (int)(Math.random()*FILAS);
                c = (int)(Math.random()*COLUMNAS);
            } while(tableroMinas[f][c] == true);
            
            tableroMinas[f][c] = true;
        }        
    }

    
    static void imprimirTableroMinas(){
        for(int j = 0; j < COLUMNAS; j++){
            if (j==0) System.out.print("   ");
            System.out.print(j % 10 + " ");
        }
        System.out.println("");

        for(int i = 0; i < FILAS; i++){
            System.out.print(i % 10 + ": ");
            
            for(int j = 0; j < COLUMNAS; j++){
                if (tableroMinas[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }                   
            }
            System.out.println("");
        }            
    }
    
    
}
