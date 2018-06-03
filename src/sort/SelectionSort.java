package sort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 16.01.2018.
 */
public class SelectionSort {

    public static void main(String[] args) {

        List<Serializable> list = new ArrayList<>();
        list.add(3);
       // List<Number> newList =  A.showAll(list);
    }

     static class A {
        public static List<Number> showAll(List<? extends Number> numbers){
            numbers.forEach(num -> System.out.println(num));
         //   numbers.add(new Integer(3));
            return (List<Number>) numbers;
        }
    }
}
