package ud6.examentestud06;

public class Test01 {
    public static <T> T medio(T[] t) {
        return t[t.length / 2];
    }

    public static void main(String[] args) {
        Integer[] tInt= {1, 2, 3, 4, 5};
        String[] tStr= {"Hello", "World"};

        System.out.print(medio(tInt) + " " + medio(tStr));
    }
}
