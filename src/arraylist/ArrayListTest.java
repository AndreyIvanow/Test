package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println("");
        List<String> list = new ArrayList<>(5);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.remove(0);
        list.remove(1);

        int[] mas = new int[3];
        System.out.println(mas[1]);
    }
}
