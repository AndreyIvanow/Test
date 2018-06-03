package linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("One");
        set.add("TWO");
        set.add("three");
        set.add("foor");
        set.add("five");
        set.add("six");
        set.add("seven");

        System.out.println(set);
    }

}
