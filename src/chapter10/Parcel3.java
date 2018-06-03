package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class Parcel3 {

    class Contents{
        private int i = 11;
        public int value(){
            return 11;
        }
    }

    class Destination{
        private String label;

        Destination(String whereTo){
            label = whereTo;
        }

        String readLabel(){
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Destination d = p.new Destination("Tasmania");
        Parcel3.Contents c = p.new Contents();
    }
}
