package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class AnonymousConstructor {

    public static Base getBase(int i){
        return new Base(i){
            {
                System.out.println("Inside instance initializer");
            }

            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
