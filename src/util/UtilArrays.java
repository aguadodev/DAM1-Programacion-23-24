package util;

import java.util.Arrays;

public class UtilArrays {

    /**
     * Inicializa los elementos de un array de enteros a un valor fijo que se pasa como parámetro.
     * @param t
     * @param valor
     */
    static void inicializarValoresFijos(int[] t, int valor) {
        for(int i = 0; i < t.length; i++){
            t[i] = valor;
        }
    }


    /**
     * Inicializa los elementos de un array de enteros a un valor aleatorio entre 0 y 9 inclusives.
     * @param t
     */
    static void inicializarValoresAleatorios(int[] t) {
        for(int i = 0; i < t.length; i++){
            t[i] = (int)(Math.random()*10);
        }
    }
    

    /**
     * Comprueba si un array de enteros está ordenado ascendentemente.
     * @param t
     * @return
     */
    static boolean estaOrdenadoAsc(int[] t) {
        boolean ordenado = true;
    
        int i = 0;
        while (i < (t.length - 1) && ordenado) {
            if (t[i] > t[i+1]){
                ordenado = false;
            }            
            i++;
        }
        return ordenado;
    }
    

    /**
     * Ordena un array de enteros ascendentemente usando el algoritmo de Burbuja.
     * @param t
     */
    static void ordenarAsc(int[] t) {   
        int vueltas = t.length - 1; // Máximo número de vueltas para ordenar el array
        boolean ordenado = false;        
    
        while (vueltas > 0 && !ordenado) {
            ordenado = true;             
            // En cada vuelta, el elemento más grande queda ordenado al final,
            // por eso en cada vuelta solo necesitamos recorrer el array hasta
            // una posicion menos cada vez
            for(int i = 0; i < vueltas; i++) {
                // En cada vuelta comenzamos suponiendo el array ordenado, de modo
                // que si al final de la vuelta no hubo que hacer intercambios 
                // el bucle terminará porque el array ya estará ordenado
                if (t[i] > t[i+1]){
                    // Si dos elementos contiguos están desordenados se intercambian
                    int aux = t[i];
                    t[i] = t[i+1];
                    t[i+1] = aux;
                    ordenado = false;
                }  
            }
            vueltas--;
        }         
    }
    

    /**
     * Ordena un array de enteros descendentemente usando el algoritmo de Burbuja.
     * @param t
     */
    static void ordenarDesc(int[] t) {   
        int vueltas = t.length - 1; // Máximo número de vueltas para ordenar el array
        boolean ordenado = false;        
    
        while (vueltas > 0 && !ordenado) {
            ordenado = true;             
            // En cada vuelta, el elemento más grande queda ordenado al final,
            // por eso en cada vuelta solo necesitamos recorrer el array hasta
            // una posicion menos cada vez
            for(int i = 0; i < vueltas; i++) {
                // En cada vuelta comenzamos suponiendo el array ordenado, de modo
                // que si al final de la vuelta no hubo que hacer intercambios 
                // el bucle terminará porque el array ya estará ordenado
                if (t[i] < t[i+1]){
                    // Si dos elementos contiguos están desordenados se intercambian
                    int aux = t[i];
                    t[i] = t[i+1];
                    t[i+1] = aux;
                    ordenado = false;
                }  
            }
            vueltas--;
        }         
    }
    

    /**
     * Búsqueda lineal de un valor en un array de enteros y devuelve la posición de la primera ocurrencia.
     * Si no se encuentra devuelve -1.
     * @param t
     * @param val
     * @return
     */
    static int busquedaLinealNoOrdenado(int[] t, int val) {
        int posicion = -1;
    
        int i = 0;
        while (i < t.length && posicion == -1) {
            if (t[i] == val) {
                posicion = i;
            }                        
            i++;
        }
    
        return posicion;
    }
    

    /**
     * Búsqueda lineal de un valor en un array de enteros ordenado. Si no se encuentra devuelve -1.
     * @param t
     * @param val
     * @return
     */
    static int busquedaLinealOrdenado(int[] t, int val) {
        int posicion = -1;
    
        int i = 0;
        while (i < t.length && posicion == -1 && t[i] < val) {
            if (t[i] == val) {
                posicion = i;
            }                        
            i++;
        }
    
        return posicion;
    }

    /**
     * Búsqueda dicotómica en un valor en un array de enteros ordenado. Si no se encuentra devuelve -1.
     * @param t
     * @param val
     * @return
     */
    static int busquedaBinaria(int[] t, int val) {
        int posicion = -1; // resultado, inicialmente suponemos no encontrado
        int inicio = 0, fin = t.length - 1; // indices del rango a buscar
        int centro = (fin + inicio) / 2; // Indice central
    
        // Mientras exista rango a buscar y no se encuentre el valor buscado
        while (inicio <= fin && posicion == -1) {          
            if (val == t[centro]) {
                // Si se encuentra el valor en la posicion central
                posicion = centro;
            } else {
                // Si no se encuentra en la posicion central actualizamos el rango
                if (val > t[centro]) {
                    // Busca en la parte derecha del array => adelanta el inicio
                    inicio = centro + 1;
                } else {
                    // Busca en la parte izquierda del array => retrocede el final
                    fin = centro - 1;
                }
                // Calcula de nuevo el índice central
                centro = (fin + inicio) / 2;
            }                        
        }
    
        return posicion;
    } 
    

    /**
     * Inserta un valor al final de un array de enteros.
     * @param t
     * @param val
     * @return
     */
    static int[] insertarFinal(int[] t, int val) {
        int[] t2 = new int[t.length+1];
        
        for(int i = 0; i < t.length; i++) {
            t2[i] = t[i];
        }
        t2[t.length] = val;

        return t2;
    }
    

    
    /**
     * Inserta un valor al inicio de un array de enteros.
     * @param t
     * @param val
     * @return
     */
    static int[] insertarInicio(int[] t, int val) {
        int[] t2 = new int[t.length + 1];
        
        t2[0] = val;
        
        for(int i = 0; i < t.length; i++) {
            t2[i+1] = t[i];
        }
            
        return t2;
    }
    

    /**
     * Inserta un valor en una posición dada de un array de enteros.
     * @param t
     * @param val
     * @param pos
     * @return
     */
    static int[] insertarEnPosicion(int[] t, int val, int pos) {
        int[] t2 = new int[t.length + 1];
    
        for(int i = 0; i < pos; i++) {
            t2[i] = t[i];
        }   
        
        t2[pos] = val;
        
        for(int i = pos; i < t.length; i++) {
            t2[i+1] = t[i];
        }
            
        return t2;
    }


    /**
     * Inserta un elemento en un array de enteros ordenado ascendentemente.
     * @param t
     * @param val
     * @return
     */
    static int[] insertarEnOrdenadoAsc(int[] t, int val) {
        int[] t2 = new int[t.length + 1];
        
        int i = 0;
        while(i < t.length && t[i] < val){
            t2[i] = t[i]; 
            i++;
        }
        
        t2[i] = val;
        
        for(int j = i; j < t.length; j++ ){
            t2[j+1] = t[j];
        }              
        
        return t2;
    }
    

    /**
     * Elimina el elemento al final de un array de enteros.
     * @param t
     * @return
     */
    static int[] eliminarFinal(int[] t){
        int[] t2;
        
        // Comprueba si el array de entrada está vacío
        if(t.length > 0) {
            t2 = new int[t.length - 1]; // crea el array auxiliar
            
            // Copia los elementos del array original en el auxiliar 
            // salvo el último
            for(int i = 0; i < t.length - 1; i++){
                t2[i] = t[i];
            }
        } else {
            // Si el array de entrada está vacío devuelve un array vacío
            t2 = new int[0];
        }
        
        return t2;
    }


    /**
     * Elimina el elemento al final de un array de enteros.
     * @param t
     * @return
     */
    //static int[] eliminarInicio(int[] t){}


    //static int[] eliminarEnPosicion(int[] t, int pos){}


    //static int[] eliminarvalores(int[] t, int valor){}


    //static int[] invertir(int[] t){}
    

    /**
     * Obtiene la moda (el valor que más se repite) de un array de enteros.
     * @param t
     * @return
     */
    static int moda(int[] t){
        int moda = -1;
        int maxRepe = 0;
    
        Arrays.sort(t);
    
        int numActual = t[0];
        int repeActual = 0;
    
        for (int i = 0; i < t.length; i++) {
            if (t[i]  == numActual){
                repeActual++;
                if (repeActual > maxRepe) {
                    maxRepe++;
                    moda = numActual;
                } else if (repeActual == maxRepe) {
                    moda = -1;
                }
            } else {
                numActual = t[i];
                repeActual = 1;
            }
        }
    
        return moda;
    }
    
    
    /**
     * Obtiene la mediana de un array de enteros.
     * La mediana es el valor que deja el mismo número de elementos a su derecha y a su izquierda.
     * @param t
     * @return
     */
    static double mediana(int[] t) {
        double mediana;
    
        Arrays.sort(t);
    
        if (t.length % 2 == 0) {
            mediana = (t[t.length / 2] + t[t.length / 2 - 1]) / 2.0;
        } else {
            mediana = t[t.length / 2];
        }       
    
        return mediana;
    }    
    
    
    /**
     * Devuelve la suma de los elementos de un array.
     * @param t
     * @return
     */
    static int suma(int[] t) {
        int suma = 0;
    
        for (int i = 0; i < t.length; i++) {
            suma += t[i];
        }        
    
        return suma;
    }
    
    
    /**
     * Devuelve la media de los elementos de un array.
     * @param t
     * @return
     */
    static int media(int[] t) {
        int suma = 0;
    
        for (int i = 0; i < t.length; i++) {
            suma += t[i];
        }        
    
        return suma / t.length;
    }
    
    
    /**
     * Devuelve el mínimo de los elementos de un array.
     * @param t
     * @return
     */
    static int minimo(int[] t) {
        int minimo = t[0];
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] < minimo) {
                minimo = t[i];
            }
        }        
    
        return minimo;
    }   
    
    
    /**
     * Devuelve el máximo de los elementos de un array.
     * @param t
     * @return
     */
    static int maximo(int[] t) {
        int maximo = t[0];
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] < maximo) {
                maximo = t[i];
            }
        }        
    
        return maximo;
    }  
    


}
