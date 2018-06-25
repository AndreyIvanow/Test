package cloning.arraylist;
// Поскольку он клонируемый, наследование
// не сделает его не клонируемым:
public class Int3 extends Int2 {

    private int j;
    public Int3(int i) {
        super(i);
        j = 4;
    }

    @Override
    public String toString() {
        return "Int3{" +
                "j=" + j +
                '}';
    }
}
