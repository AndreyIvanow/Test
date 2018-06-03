package serializationstaticfields.package2;

public class Circle extends Shape {

    private static int color = RED;
    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;

    }

    public int getColor() {
        return color;
    }
}
