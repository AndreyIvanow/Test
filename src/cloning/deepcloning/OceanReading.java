package cloning.deepcloning;

public class OceanReading implements Cloneable {

    private DepthReading depth;
    private TemperatureReading temperature;

    public OceanReading(double tdata, double ddata){
        temperature = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    public Object clone() {
        OceanReading o = null;
        try {
            o = (OceanReading)super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
        // Необходимо клонировать ссылку:
        o.depth = (DepthReading)o.depth.clone();
        o.temperature =
                (TemperatureReading)o.temperature.clone();
        return o;
    }

}
