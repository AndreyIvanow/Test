package cloning.localcopy;

public class MyObject implements Cloneable {

    int i;

    MyObject(int ii) {
        i = ii;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println("MyObject не может быть клонирован");
        }
        return o;
    }

    public String toString() {
        return Integer.toString(i);
    }

}
