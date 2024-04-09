package ud6.examentestud06;

import java.util.Set;
import java.util.TreeSet;

public class Test02 {

    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Bob");
        names.add("Alice");
        names.add("Bob");

        System.out.println(names);

    }
}
