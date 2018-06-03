package serializationstaticfields.package2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        // Add references to the class objects:
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        // Make some shapes:
        for(int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        // Set all the static colors to GREEN:
        for(int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));

        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
    }
}
