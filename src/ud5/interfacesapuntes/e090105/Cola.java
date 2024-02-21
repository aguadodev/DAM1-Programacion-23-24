package ud5.interfacesapuntes.e090105;

import java.util.Arrays;

public interface Cola {
    void encolar(Integer e);
    Integer desencolar();

    default void encolarMultiple(Integer e, int nRep){
        for(int i = 0; i < nRep; i++){
            encolar(e);
        }
    }

   default Integer[] desencolarTodos(){
        Integer[] elementos = new Integer[0];
        
        Integer e = desencolar();
        
        while (e != null) {
            // Guardar e en el array elementos
            elementos = Arrays.copyOf(elementos, elementos.length + 1);
            elementos[elementos.length - 1] = e;

            // Desencolar otro elemento
            e = desencolar();
        }            
                      
        return elementos.length > 0 ? elementos : null;
    }


}
