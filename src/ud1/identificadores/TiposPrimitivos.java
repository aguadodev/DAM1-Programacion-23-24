package ud1.identificadores;

public class TiposPrimitivos {
    public static void main(String[] args) {
        byte varByte = 124;
        System.out.println(
                "La variable varByte es de tipo byte, tiene el valor " + varByte + " y ocupa 8 bits en memoria.");

        short varShort = 12234;
        System.out.println(
                "La variable varShort es de tipo short, tiene el valor " + varShort + " y ocupa 16 bits en memoria.");

        int varInt = 214748364;
        System.out.println(
                "La variable varInt es de tipo int, tiene el valor " + varInt + " y ocupa 32 bits en memoria.");

        long varLong = 9223372036854775807L;
        System.out.println(
                "La variable varLong es de tipo long, tiene el valor " + varLong + " y ocupa 64 bits en memoria.");

        float varFloat = 124.4F;
        System.out.println(
                "La variable varFloat es de tipo float, tiene el valor " + varFloat + " y ocupa 32 bits en memoria.");

        double varDouble = 124.1273276;
        System.out.println(
                "La variable varDouble es de tipo double, tiene el valor " + varDouble + " y ocupa 64 bits en memoria.");

        char varChar = '\u3344';
        System.out.println(
                "La variable varChar es de tipo char, tiene el valor " + varChar + " y ocupa 16 bits en memoria.");

        boolean varBoolean = true;
        System.out.println(
                "La variable varBoolean es de tipo boolean, tiene el valor " + varBoolean + " y ocupa 1 bits en memoria.");


        System.out.println("Tipo\t| NumBits\t| Valor");                
        System.out.println("-------------------------------");                
        System.out.println("byte\t| 8\t\t| " + varByte);
        System.out.println("short\t| 16\t\t| " + varShort);
        System.out.println("int\t| 32\t\t| " + varInt);
        System.out.println("long\t| 64\t\t| " + varLong);
        System.out.println("float\t| 32\t\t| " + varFloat);
        System.out.println("double\t| 64\t\t| " + varDouble);
        System.out.println("char\t| 16\t\t| " + varChar);
        System.out.println("boolean\t| 1\t\t| " + varBoolean);

    }
}
