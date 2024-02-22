package ud5.interfacesapuntes.e0911;

import java.util.Arrays;


public class Lista {
    private Object[] elementos;

    /*
    MÉTODOS PROPIOS DE LA CLASE
    */    
    public int length(){
        return elementos.length;
    }
    
    public void addFinal(Object e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = e;
    }
    
    public void addInicio(Object e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        for(int i = elementos.length - 1; i > 0; i--){
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = e;
    }    
    
    public void addPosicion(Object e, int pos){
        if (pos >= 0 && pos <= elementos.length) {
            // Amplío el array
            elementos = Arrays.copyOf(elementos, elementos.length + 1);

            // Hago hueco al nuevo elemento
            for(int i = elementos.length - 1; i > pos; i--){
                elementos[i] = elementos[i - 1];
            }            
            // Inserto el nuevo elemento
            elementos[pos] = e;
        }              
    }    
    
    public void mostrar(){
        System.out.println(Arrays.toString(elementos));
    }
    
    public void addLista(Lista lista){
        // Amplío el array
        elementos = Arrays.copyOf(elementos, elementos.length + lista.length()); 
        // copiamos elementos de la lista que se pasa como parámetro
        for (int i = 0; i < lista.length(); i++){
            elementos[elementos.length - lista.length() + i] = lista.elementos[i];
        }
    }
    
    public Object delPosicion(int pos){
        Object e = elementos[pos];
        
        for(int i = pos; i < elementos.length - 1; i++){
            elementos[i] = elementos[i+1];
        }
        
        elementos = Arrays.copyOf(elementos, elementos.length - 1);         
        
        return e;
    }
    
    public Object getPosicion(int pos){            
        return elementos[pos];
    }    

    public Object buscar(Object e){
        int i = 0;
        boolean encontrado = false;
        
        while (i < elementos.length && !encontrado){
            if (elementos[i] == e) {
                encontrado = true;
            }
            i++;
        }
        
        if (encontrado) {
            return i - 1;
        } else {
            return - 1;
        }            
    }  
    
    public static Lista concatena(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        
        l3.addLista(l1);
        l3.addLista(l2);
       
        return l3;
    }
    

    public Lista() {
        elementos = new Object[0];
    }
    /*
    IMPLEMENTACIÓN DE LA INTERFAZ COLA
    */
    // Encolar
    public void encolar(Object e){
        addFinal(e);        
    }
    // Desencolar
    public Object desencolar(){
        return delPosicion(0);
    }

    /*
    IMPLEMENTACIÓN DE LA INTERFAZ COLADOBLE
    */
    // EncolarCabeza
    public void encolarCabeza(Object e){
        addInicio(e);        
    }
    // DesencolarFinal
    public Object desencolarFinal(){
        return delPosicion(length() - 1);
    }

    /*
    IMPLEMENTACIÓN DE LA INTERFAZ PILA
    */
    public void apilar(Object e){
        addFinal(e);
    }
    
    public Object desapilar(){
        return delPosicion(length() - 1);
    }              
    
}
