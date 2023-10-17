import javax.swing.JOptionPane;

public class Dialogos {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog(null, "¿Cómo te llamas?");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos años tienes?"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cuántos kilos pesas (con decimales)?"));


        JOptionPane.showMessageDialog(null, "Hola " + nombre + "!!\n" +
        "Tienes " + edad + " años y pesas " + peso + " kilos");

        if (JOptionPane.showConfirmDialog(null, "¿Quieres continuar?") == 0) {
            double estatura = Double.parseDouble(JOptionPane.showInputDialog(null, "¿Cuánto mides (en metros con decimales)?"));
            double imc = peso / Math.pow(estatura, 2);
            JOptionPane.showMessageDialog(null, String.format("Tu índice de masa corporal (IMC) es de %.2f", imc));            
        } else {
            JOptionPane.showMessageDialog(null, "Hasta la próxima");
        }
    }
}
