package ud5.clasesapuntes.E0710.personal;

public class Mecanico {
    String nombre;
    String telefono;
    public enum Especialidad {FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR}
    Especialidad especialidad;

    public Mecanico(String nombre, String telefono, Especialidad especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        String str = nombre;
        
        str += telefono != null ? "; Teléfono = " + telefono : "";
        str += especialidad != null ? "; Especialidad = " + especialidad : "";
        
        return str;
        
    }    

    
}
