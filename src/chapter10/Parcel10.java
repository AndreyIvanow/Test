package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class Parcel10 {

    public Destination destination(final String dest, final float price){
        return new Destination() {
            private String label = dest;
            private int cost;
            {
                cost = Math.round(price);
                if (cost > 100){
                    System.out.println("Over budget!");
                }
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
