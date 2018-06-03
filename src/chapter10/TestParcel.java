package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
     //   Parcel4.PDestination pd = p.new PDestination();
    }


}
