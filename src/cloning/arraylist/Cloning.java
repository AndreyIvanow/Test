package cloning.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Cloning {

    public static void main(String[] args) {
        ArrayList v = new ArrayList();
        for (int i = 0; i < 10; i++){
            v.add(new Int(i));
        }
        System.out.println("v: " + v);
        ArrayList v2 = (ArrayList)v.clone();
        System.out.println(v2 == v);
        // Увеличение всех элементов v2:
        for(Iterator e = v2.iterator();e.hasNext(); )
            ((Int)e.next()).increment();
        // Проверка изменения элементов v:
        System.out.println("v: " + v);
    }
}
