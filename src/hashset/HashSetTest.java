package hashset;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("One");
        set.add("Two");

        set.remove("One");

        System.out.println(set.contains("ASD"));

        System.out.println(set);

    }
}
