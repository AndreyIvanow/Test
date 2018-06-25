package cloning.deepcloning;

public class DeepCopy {

    public static void main(String[] args) {
        OceanReading reading = new OceanReading(33.9, 100.5);
        // Теперь клонируем его:
        OceanReading r = (OceanReading)reading.clone();
    }
}
