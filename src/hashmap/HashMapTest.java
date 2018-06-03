package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapTest {

    public static void main(String[] args) {
        /*HashMap<String, BigDecimal> map = new HashMap<>(3, 2.2F);

        map.put("First", new BigDecimal(100));
        map.put("Second", new BigDecimal(20));
        map.put("Third", new BigDecimal(30));
        map.put("Fourth", new BigDecimal(60));
        map.put("Fifth", new BigDecimal(61));
        map.put("Fifth", new BigDecimal(62));
        map.put("Sixth", null);

        System.out.println(map.containsKey("Sixth"));

        System.out.println(map.get("Fifth"));

        HashMap<MyClass, Integer> map1 = new HashMap<>();
        MyClass key1 = new MyClass("One");
        MyClass key2 = new MyClass("One");
        MyClass key3 = new MyClass("Two");
        map1.put(key1, 1);
        map1.put(key2, 2);
        map1.put(key3, 3);
        System.out.println(map1.get(key1));
        System.out.println(map1.get(key2));
        System.out.println(map1);

        map1.entrySet();*/

        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "10");
        map2.put("2", "20");
        map2.put(null, "100");

        // если ключа "4" нет, то добавить этому ключу значение "4"
        map2.computeIfAbsent("4", v -> v);
        map2.computeIfAbsent("5", v -> null); //null value won't get inserted
        // если ключ "2" присутствует, то перезаписать значение на key + value
        map2.computeIfPresent("2", (k, v) -> k + v);
        System.out.println("Before compute " + map2);
        // неважно присутствует или отсутсвует ключ
        map2.compute("6", (k , v) -> k + v);
        System.out.println("After compute " + map2);

        map2.merge("7", "70", (k, v) -> k + v);
        // если ключа "1" нет , то добавит со значением "11" иначе перезапишет результатом лямбда функции
        map2.merge("1", "11", (oldValue, newValue) -> oldValue + newValue);
        System.out.println("After merge " + map2);

        map2.remove("1");

    }

    static class MyClass{
        private String key;

        public MyClass(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyClass myClass = (MyClass) o;
            return Objects.equals(key, myClass.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}
