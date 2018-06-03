package serialization.persistancesavingproblems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWorld {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: " + animals);

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        // Write a 2nd set
        o1.writeObject(animals);
        // Write to a different stream:
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);

        // Now get them back:
        ObjectInputStream in1 = new ObjectInputStream(
                new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(buf2.toByteArray()));

        List
                animals1 = (List)in1.readObject(),
                animals2 = (List)in1.readObject(),
                animals3 = (List)in2.readObject();

        // animals1 и animal2 восстановлены из одного потока, у них House ссылается на один и тот же объект, как было до сериализации
        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);
        // animal3 восстановлен из другого потока, объект House создан новый
        System.out.println("animals3: " + animals3);
    }
}
