package ud4.examenud04rec;

public class Sumas {

    public static int[] sumas(int[] t) {
        
        int[] res = {0,0,0};

        if (t != null) {
            for (int num : t) {
                // Suma total
                res[0] += num;
                if (num > 0)
                    // Suma positivos 
                    res[1] += num;
                else if (num < 0)
                    // Suma negativos
                    res[2] += num;
            }
        }

        return t == null ? null : res;
    }
}
