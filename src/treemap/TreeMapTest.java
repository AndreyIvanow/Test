package treemap;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");


        System.out.println(map.get(2));

        map.remove(5);

        System.out.println();

        // методы SortedMap
        // выведет 2 и 3
        System.out.println("SubMap " + map.subMap(2, 4));

        // возвращает все элементы, у которых ключ меньше 3
        System.out.println("HeadMap " + map.headMap(3));
        // возвращает все элементы, у которых ключ больше или равен 3
        System.out.println("TailMap " + map.tailMap(3));

        System.out.println("FirstKey " + map.firstKey());
        System.out.println("LastKey " + map.lastKey());

        // методы NavigableMap
        // возвращает элемент с ключом меньшим 3
        System.out.println("LowerEntry " + map.lowerEntry(3));
        System.out.println("LowerKey " + map.lowerKey(3));

        // с ключом большим чем три
        System.out.println("HigherEntry " + map.higherEntry(3));
        System.out.println("HigherKey " + map.higherKey(3));

        // с ключом большим либо равным три
        System.out.println("CeilingEntry " + map.ceilingEntry(3));
        System.out.println("CeilingKey " + map.ceilingKey(3));

        // с ключом меньшим либо равным три
        System.out.println("FloorEntry " + map.floorEntry(3));
        System.out.println("FloorKey " + map.floorKey(3));

        System.out.println("PoolFirstEntry " + map.pollFirstEntry());
        System.out.println("PoolLastEntry " + map.pollLastEntry());

        System.out.println(map.descendingMap());




    }
}
