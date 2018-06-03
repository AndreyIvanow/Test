package linkedhashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();

        map1.put("1", "one");
        map1.put("2", "two");
        map1.put("4", "four");
        map1.put("3", "three");
        map1.put("5", "five");

        // в каком порядке добавляли в таком они и выведутся
        System.out.println(map1);

        LinkedHashMap<String, String> map2 = new LinkedHashMap<>(16, 0.75F, true);

        map2.put("1", "one");
        map2.put("2", "two");
        map2.put("3", "three");
        map2.put("4", "four");
        map2.put("5", "five");

        System.out.println(map2);

        System.out.println();

        // ключ "4" помещается в конец
        map2.get("4");
        // ключ "2" помещается в конец
        map2.get("2");

        System.out.println(map2);


    }
}
