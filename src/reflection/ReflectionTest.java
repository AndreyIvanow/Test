package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class[] interfaces = List.class.getInterfaces();
        for(Class clazz : interfaces){
            System.out.println(clazz.getName());
        }
        Class parent = String.class.getSuperclass();
        System.out.println(parent.getName());

        Method[] methods = List.class.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        String s = String.class.newInstance();

        String string = String.class.newInstance();
        Method m = String.class.getMethod("length");
        System.out.println((int) m.invoke(string));
    }
}
