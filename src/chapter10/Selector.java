package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public interface Selector {
    boolean end();
    Object current();
    void next();
}
