package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class Parcel4 {

    private class PContents implements Contents {
        private int i = 11;
        public int value() { return i; }
    }

    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }
}
