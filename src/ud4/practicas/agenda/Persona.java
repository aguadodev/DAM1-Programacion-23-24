package ud4.practicas.agenda;

public class Persona {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;

    public Persona(String nombre, String apellidos, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + telefono + " / " + email + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    

    
}
