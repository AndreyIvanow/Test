package chapter10;

/**
 * Created by Андрей on 09.07.2017.
 */
public class Implementation2 implements Service {

    private Implementation2(){

    }

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}
