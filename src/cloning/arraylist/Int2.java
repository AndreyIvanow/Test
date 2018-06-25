package cloning.arraylist;

public class Int2 implements Cloneable {
    private int i;

    public Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    public String toString() {
        return Integer.toString(i);
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException e) {
            System.err.println("Int2 не может быть клонирован");
        }
        return o;
    }
}
