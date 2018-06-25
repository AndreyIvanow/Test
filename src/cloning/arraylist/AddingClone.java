package cloning.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class AddingClone {

    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = (Int2)x.clone();
        x2.increment();
        System.out.println(
                "x = " + x + ", x2 = " + x2);
        // Все наследники также являются клонируемыми:
        Int3 x3 = new Int3(7);
        x3 = (Int3)x3.clone();
        // Поле j клонируется без проблем, хотя вызывается clone у Int2 а не nt3
        System.out.println("x3 = " + x3);

        ArrayList v = new ArrayList();
        for(int i = 0; i < 10; i++ )
            v.add(new Int2(i));
        System.out.println("v: " + v);
        ArrayList v2 = (ArrayList)v.clone();
        // Теперь клонируем каждый элемент:
        for(int i = 0; i < v.size(); i++)
            v2.set(i, ((Int2)v2.get(i)).clone());
        // Увеличиваемзначения всех элементов v2:
        for(Iterator e = v2.iterator(); e.hasNext(); )
            ((Int2)e.next()).increment();
        // Смотрим, изменились ли значения элементов v:
        System.out.println("v: " + v);
        System.out.println("v2: " + v2);
    }
}
