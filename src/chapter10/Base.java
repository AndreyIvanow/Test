package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}
