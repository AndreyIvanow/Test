package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("c");
        list.add("d");
        list.add(1, "b");
        list.get(3);

        list.addFirst("g");

        list.remove();
        list.remove(7);
        System.out.println(list);

    }
}
