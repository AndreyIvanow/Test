package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class Parcel7 {

    public Contents contents(){
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
